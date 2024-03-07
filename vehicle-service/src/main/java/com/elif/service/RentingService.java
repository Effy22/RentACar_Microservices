package com.elif.service;

import com.elif.constant.Calculations;
import com.elif.dto.request.CancellationRequestDto;
import com.elif.dto.request.RequestRentingDto;
import com.elif.entity.Renting;
import com.elif.entity.Vehicle;
import com.elif.exception.ErrorType;
import com.elif.exception.VehicleServiceException;
import com.elif.manager.ElasticRentingManager;
import com.elif.manager.UserManager;
import com.elif.repository.RentingRepository;
import com.elif.utility.ServiceManager;
import com.elif.utility.enums.EStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentingService extends ServiceManager<Renting,String> {

    private final RentingRepository rentingRepository;
    private final VehicleService vehicleService;
    private final Calculations calculations;
    private final UserManager userManager;
    private final ElasticRentingManager elasticRentingManager;

    public RentingService(RentingRepository rentingRepository,VehicleService vehicleService,Calculations calculations,UserManager userManager,ElasticRentingManager elasticRentingManager) {
        super(rentingRepository);
        this.vehicleService = vehicleService;
        this.rentingRepository = rentingRepository;
        this.calculations = calculations;
        this.userManager = userManager;
        this.elasticRentingManager = elasticRentingManager;
    }

    public String requestRenting(RequestRentingDto requestRentingDto) {

        Optional<Vehicle> optionalVehicle = vehicleService.findById(requestRentingDto.getVehicleId());
        if(optionalVehicle.isPresent()){

            Vehicle vehicle = optionalVehicle.get();

            if(vehicle.getStatus().equals(EStatus.AVAILABLE) && vehicle.getFuel()>35){

                Double price = calculations.calculateRentingPrice(
                        requestRentingDto.getStartDate(),
                        requestRentingDto.getEndDate(),vehicle.getDailyPrice()
                );

               Double userBalance= userManager.getUserBalance(requestRentingDto.getUserId()).getBody();

                if(userBalance>=price){
                    Renting renting = Renting.builder()
                            .price(price)
                            .startDate(requestRentingDto.getStartDate())
                            .endDate(requestRentingDto.getEndDate())
                            .userId(requestRentingDto.getUserId())
                            .createDate(System.currentTimeMillis())
                            .vehicleId(requestRentingDto.getVehicleId())
                            .pickUpLocation(requestRentingDto.getPickUpLocation())
                            .dropOffLocation(requestRentingDto.getDropOffLocation())
                            .notes(requestRentingDto.getNotes())
                            .build();
                    rentingRepository.save(renting);
                    vehicle.setStatus(EStatus.NOT_AVAILABLE);
                    vehicleService.save(vehicle);
                    userManager.addRenting(renting.getId(),requestRentingDto.getUserId());

                    //TODO: Elastic'e gönderilecek save metodu ile.

                    return "İstemiş olduğunuz araç kiralanmak için uygundur. Kiralama işleminiz başarılı bir şekilde gerçekleşti.";
                }else{
                    throw new VehicleServiceException(ErrorType.NOT_ENOUGH_BALANCE);
                }
            }else{
                throw new VehicleServiceException(ErrorType.VEHICLE_CANNOT_FOUND);
            }
        }else{
            throw new VehicleServiceException(ErrorType.RENTING_ERROR);
        }


    }

    public String cancelRenting(CancellationRequestDto dto) {
        Optional<Renting> optionalRenting = rentingRepository.findById(dto.getId());

        if (optionalRenting.isPresent()) {
            Renting renting = optionalRenting.get();
            rentingRepository.deleteById(renting.getId());
            return "Kiralama işleminiz iptal edildi.";
        } else {
            throw new VehicleServiceException(ErrorType.RENTING_NOT_FOUND);
        }

    }
}
