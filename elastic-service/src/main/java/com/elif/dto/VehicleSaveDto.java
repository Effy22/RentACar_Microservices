package com.elif.dto;

import com.elif.utility.enums.EBrand;
import com.elif.utility.enums.ECategory;
import com.elif.utility.enums.EModel;
import com.elif.utility.enums.EStatus;

public record VehicleSaveDto(

        String id,
        String name,
        Integer year,
        EModel model,
        EBrand brand,
        Integer fuel,
        Double dailyPrice,
        Double hourPrice,
        String licencePlate,
        String color,
        Integer kilometers,
        EStatus status,
        ECategory category,
        String description
) {
}
