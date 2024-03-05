package com.elif.entity;

import com.elif.utility.enums.ELocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Renting extends BaseEntity{
    @Id
    String id;
    String userId;
    String vehicleId;
    Date startDate;
    Date endDate;
    ELocation pickUpLocation;
    ELocation dropOffLocation;
    Double price;
    String notes;
}
