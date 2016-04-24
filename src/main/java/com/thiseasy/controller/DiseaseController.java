package com.thiseasy.controller;

import com.thiseasy.model.Disease;
import com.thiseasy.repository.IDiseaseRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiseaseController {
 
    @Autowired
    private IDiseaseRepository repo;
 
    static final Logger logger = LogManager.getLogger(DiseaseController.class.getName());

    @RequestMapping(path = "/Disease", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Disease disease) {
        try {
            repo.save(disease);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        return String.valueOf(disease.getId());
    }


    @RequestMapping(path = "/Disease", method = RequestMethod.GET)
    @ResponseBody
    public Disease findOne(long id) {
        return repo.findOne(id);
    }

    @RequestMapping(path = "/Diseases", method = RequestMethod.GET)
    @ResponseBody
    public List<Disease> findAll() {
        Iterable<Disease> diseaseIter = repo.findAll();
        List<Disease> disease = new ArrayList<>();
        for(Disease entity:diseaseIter){
            disease.add(entity);
        }
        return disease;
    }


}