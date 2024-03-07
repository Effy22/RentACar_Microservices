package com.elif.dto.request;

import com.elif.utility.enums.ELocation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestRentingDto {
    String token;
    String userId;
    String vehicleId;
    Date startDate;
    Date endDate;
    ELocation pickUpLocation;
    ELocation dropOffLocation;
    Double price;
    String notes;
}
