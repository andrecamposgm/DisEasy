package com.thiseasy.repository;

import com.thiseasy.model.Disease;
import org.springframework.data.repository.CrudRepository;


public interface IDiseaseRepository extends CrudRepository<Disease, Long> {


}