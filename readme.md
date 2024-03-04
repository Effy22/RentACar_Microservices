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

