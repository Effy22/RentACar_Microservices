# MONGODB 
- User-Service için; 
    DB Name: RentCar_UserProfile
    MONGOSH: db.createUser({user: "rentCarUser",pwd: "rentACarUser*",roles: ["readWrite","dbAdmin"]}) 

- Vehicle-Service için;
  DB Name: RentCar_Vehicle
    db.createUser({user: "rentCarVehicleAdmin",pwd: "rentCarVehicleAdmin*",roles: ["readWrite","dbAdmin"]}) 

## Query Methods For MongoDB;
    https://docs.spring.io/spring-data/mongodb/reference/repositories/query-methods-details.html

## CONFIG SERVER için;

    nano ~/.zshenv yada alttaki ikisi 

    CONFIG_SERVER_RENTACAR=http://localhost:8888
    
    crtl+X
    
    Y (yes)
    
    enter

# ADIMLAR;
  - OpenFeign ekleyip auth'tan user'a kullanıcı bilgisi göndermek +
  - RabbitMq ekleyip bilgilerin serverlar patlası bile kuyrukta olmasını sağlamak Auth'tan User'a +
  - Kiralama Modülü +, Ödeme Modülü ekleme (DB'leri konusunda ElasticSearch entegre etme) 
  - Spring Cloud Gateway Ekleme
  - En son ön yüz ekleme HTML 
  - Vehicle'a araç listemede redis olabilir. mongodb 
  - elastic ile mongo 

EG NOT:
    Kiralama kısmı için elastic-modülüne eklemeler yapılacak. gereksiz metotlar en son silinecek. ödeme modülü yapılacak.

    Elastic service eklendi, 

YAPILACAKLAR:
    Gateway ekle ona da security ekle muhammet hocanın elastic'inde olan