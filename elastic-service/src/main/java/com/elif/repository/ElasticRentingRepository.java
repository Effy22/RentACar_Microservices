package com.elif.repository;

import com.elif.domain.Renting;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRentingRepository extends ElasticsearchRepository <Renting,String> {

}
