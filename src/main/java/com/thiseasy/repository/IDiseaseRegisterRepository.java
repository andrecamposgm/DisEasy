package com.thiseasy.repository;

import com.thiseasy.model.DiseaseRegister;
import org.springframework.data.repository.CrudRepository;


public interface IDiseaseRegisterRepository extends CrudRepository<DiseaseRegister, Long> {


}