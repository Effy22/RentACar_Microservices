package com.elif.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(1000,"Kontroller katmanında tanımsız gelen hata oluştu. Lütfen tekrar deneyiniz.",HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_DUPLICATE_USERNAME(2000,"Kullanıcı adı zaten kayıtlı. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4110,"Kullanici adi veya sifre hatalidir...",HttpStatus.BAD_REQUEST),
    ERROR_INVALID_LOGIN_PARAMETER(2001,"Kullanıcı adı ya da parola hatalı. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_USER_ALLREADY_EXISTS(2002,"Kullanıcı adı ya da email ile mevcutta bir kayıt bulunuyor. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_CREATE_TOKEN(1003,"Token Oluşturma Hatası",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"Girilen paratmetreler hatalıdır. Lütfen düzelterek tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1002,"Gecersiz token" ,HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4115,"Token olusturulamadi..." , HttpStatus.BAD_REQUEST ),
    ACCOUNT_NOT_ACTIVE(4116,"Hesabiniz aktif degildir..." , HttpStatus.FORBIDDEN );

    int code;
    String message;
    HttpStatus httpStatus;
}
