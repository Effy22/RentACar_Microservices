# MONGODB için 
    DB Name: RentCar_UserProfile
    MONGOSH: db.createUser({user: "rentCarUser",pwd: "rentACarUser*",roles: ["readWrite","dbAdmin"]}) 

## Query Methods For MongoDB;
    https://docs.spring.io/spring-data/mongodb/reference/repositories/query-methods-details.html

## CONFIG SERVER için;

    nano ~/.zshenv yada alttaki ikisi 

    CONFIG_SERVER_RENTACAR=http://localhost:8888
    
    crtl+X
    
    Y (yes)
    
    enter

# ADIMLAR;
  - OpenFeign ekleyip auth'tan user'a kullanıcı bilgisi göndermek
  - RabbitMq ekleyip bilgilerin serverlar patlası bile kuyrukta olmasını sağlamak
  - Kiralama Modülü, Ödeme Modülü ekleme (DB'leri konusunda ElasticSearch entegre etme)
  - Spring Cloud Gateway Ekleme
  - En son ön yüz ekleme HTML 