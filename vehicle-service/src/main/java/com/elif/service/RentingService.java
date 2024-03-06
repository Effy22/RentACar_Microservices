package com.elif.service;

import com.elif.dto.request.CancellationRequestDto;
import com.elif.dto.request.RequestRentingDto;
import com.elif.entity.Renting;
import com.elif.repository.RentingRepository;
import com.elif.repository.VehicleRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RentingService extends ServiceManager<Renting,String> {

    private final RentingRepository rentingRepository;
    private final VehicleRepository vehicleRepository;

    public RentingService(RentingRepository rentingRepository,VehicleRepository vehicleRepository) {
        super(rentingRepository);
        this.vehicleRepository = vehicleRepository;
        this.rentingRepository = rentingRepository;
    }

    public String requestRenting(RequestRentingDto requestRentingDto) {
        /**
         * araç id'sinden aracın availability'sini servis ile kontrol etmek gerek,
         * user id'sinden user'ın bakiyesini kontrol etmek gerek
         * Bunun için user-microservice'i ile Openfeign koyacağım.
         *
         *   /**
         *          * Token'ın valideliğini kontrol ettik sonra (dtonun içinde)
         *          * Eğer bu user'ın bakiyesi yetiyorsa araçkiralamaya o zaman talep edilecek
         *          * Kiralama olduktan sonra aracın availability'ını false yapacak service katmanında
         *          */
        // TODO:Metot içi doldurulacak
        return "Effy";

    }

    public String cancelRenting(CancellationRequestDto dto) {
        // TODO:Metot içi doldurulacak
        return "METOT YAZILACAK";
    }
}
