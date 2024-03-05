package com.elif.entity;

import com.elif.utility.enums.EBrand;
import com.elif.utility.enums.ECategory;
import com.elif.utility.enums.EModel;
import com.elif.utility.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Vehicle extends BaseEntity{
    @Id
    String id;
    String name;
    Integer year;
    EModel model;
    EBrand brand;
    Integer fuel;
    Double dailyPrice;
    Double hourPrice;
    String licencePlate;
    String color;
    Integer kilometers;
    EStatus status;
    ECategory category;
    String description;
}
