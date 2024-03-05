package com.elif.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.elif.constant.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VEHICLE)
public class VehicleController {

    //TODO: Available araçları bulma, son konuma göre araç bulma, id ile araç bulma
    /**
     * Aracınyakıtdurumunu,saatlik,günlükvehaftalıkkiralamafiyatlarınıgörüntüler, yakıt durumu belli koşulları
     * karşılamayan araçlar görüntülenmez. (Bu koşullar uygulama sahibi tarafından belirlenir.)
     * a. İstediğisaat,günyadahaftamiktarındakiralayabilir,24saatkiralamak istediği durumlarda durumlarda günlük
     * ücret üzerinden, 36 saat kiralamak istediği durumlarda 1 gün ve 12 saatlik kiralama ücreti üzerinden hesaplanır.
     */

}
