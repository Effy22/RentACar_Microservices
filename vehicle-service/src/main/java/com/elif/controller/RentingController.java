package com.elif.controller;
// TODO: Bir kiralama yapıldığında o aracın id'si ile availabilitysini değiştirmem gerek.

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.elif.constant.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RENTING)
public class RentingController {
    //TODO: Userid ile uygun aracı bulma, aracı kiralama, aracı iptal etme tarihe göre araç seçme

}
