package com.thiseasy.controller;

import com.thiseasy.model.DiseaseRegister;
import com.thiseasy.repository.IDiseaseRegisterRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiseaseRegisterController {
 
    @Autowired
    private IDiseaseRegisterRepository repo;
 
    static final Logger logger = LogManager.getLogger(DiseaseRegisterController.class.getName());

    @RequestMapping(path = "/DiseaseRegister", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody DiseaseRegister disease) {
        try {
            repo.save(disease);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        return String.valueOf(disease.getId());
    }


    @RequestMapping(path = "/DiseaseRegister", method = RequestMethod.GET)
    @ResponseBody
    public DiseaseRegister findOne(long id) {
        return repo.findOne(id);
    }

    @RequestMapping(path = "/DiseaseRegisters", method = RequestMethod.GET)
    @ResponseBody
    public List<DiseaseRegister> findAll() {
        Iterable<DiseaseRegister> diseaseIter = repo.findAll();
        List<DiseaseRegister> disease = new ArrayList<>();
        for(DiseaseRegister entity:diseaseIter){
            disease.add(entity);
        }
        return disease;
    }


}