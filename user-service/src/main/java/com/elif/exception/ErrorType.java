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
    INVALID_TOKEN_ERROR(1001,"Sunucuda beklenmeeyen hata oluştu lütfen tekrar deneyiniz.",HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_DUPLICATE_USERNAME(2000,"Kullanıcı adı zaten kayıtlı. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4212,"Böyle bir kullanici bulunamadi...",HttpStatus.BAD_REQUEST),
    ERROR_INVALID_LOGIN_PARAMETER(2001,"Kullanıcı adı ya da parola hatalı. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(1001,"Girilen paratmetreler hatalıdır. Lütfen düzelterek tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_INVALID_USER_ID(2003,"Kullanıcı bulunamadı. Böyle bir kullanıcı bulunamadığı için güncelleme yapılamamıştır..",HttpStatus.BAD_REQUEST),
    ERROR_USER_CANNOT_CREATED(2002,"Kullanıcı oluşturulurken hata oluştu. Lütfen tekrar deneyiniz." , HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4214,"Geçersiz token" ,HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}
