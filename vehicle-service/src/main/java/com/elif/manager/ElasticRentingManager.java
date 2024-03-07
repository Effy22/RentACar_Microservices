package com.elif.manager;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "elastic-renting-service", url = "http://localhost:9200/dev/v1/elastic/renting")
public interface ElasticRentingManager {

}
