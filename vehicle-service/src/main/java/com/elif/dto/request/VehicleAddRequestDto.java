package com.elif.dto.request;

import com.elif.utility.enums.EBrand;
import com.elif.utility.enums.EModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAddRequestDto {
    String id;
    String name;
    Integer year;
    EModel model;
    EBrand brand;
}
