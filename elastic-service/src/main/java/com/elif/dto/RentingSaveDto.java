package com.elif.dto;

import com.elif.utility.enums.ELocation;

import java.util.Date;

public record RentingSaveDto(

        String id,
        String userId,
        String vehicleId,
        Date startDate,
        Date endDate,
        ELocation pickUpLocation,
        ELocation dropOffLocation,
        Double price,
        String notes
) {
}
