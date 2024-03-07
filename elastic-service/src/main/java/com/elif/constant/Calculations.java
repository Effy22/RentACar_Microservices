package com.elif.constant;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class Calculations {

    public Double calculateRentingPrice(Date startDate, Date endDate, Double vehicleDailyPrice) {

        if (startDate == null || endDate == null || vehicleDailyPrice == null) {
            throw new IllegalArgumentException("Başlangıç tarihi, bitiş tarihi veya araç günlük fiyatı null olamaz.");
        }

        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long dayDifference = endLocalDate.toEpochDay() - startLocalDate.toEpochDay();

        if (vehicleDailyPrice < 0) {
            throw new IllegalArgumentException("Araç günlük fiyatı negatif görünüyor. Lütfen düzeltin.");
        }

        return dayDifference * vehicleDailyPrice;
    }

}
