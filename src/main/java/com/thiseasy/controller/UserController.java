package com.thiseasy.controller;

import com.thiseasy.model.User;
import com.thiseasy.repository.IUserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
 
    @Autowired
    private IUserRepository repo;
 
    static final Logger logger = LogManager.getLogger(UserController.class.getName());

    @RequestMapping(path = "/User", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody User user) {
        try {
            repo.save(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        return String.valueOf(user.getId());
    }


    @RequestMapping(path = "/User", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(long id) {
        return repo.findOne(id);
    }

    @RequestMapping(path = "/Users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll() {
        Iterable<User> userIter = repo.findAll();
        List<User> users = new ArrayList<>();
        for(User u:userIter){
            users.add(u);
        }
        return users;
    }


//
//    // UPDATE
//    @RequestMapping("/movies/update")
//    @ResponseBody
//    public String readMovie(long id, String title, int year) {
//        Movie movie;
//        try {
//            movie = repo.findOne(id);
//            movie.setTitle(title);
//            movie.setYear(year);
//            repo.save(movie);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return e.getMessage();
//        }
//        return movie.getTitle() + " : " + movie.getYear();
//    }
//
//    // DELETE
//    @RequestMapping("/movies/delete")
//    @ResponseBody
//    public String deleteMovie(long id) {
//        try {
//            repo.delete(id);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return e.getMessage();
//        }
//        return "deletion successful";
//    }
//
//    @RequestMapping("/movies/readAllBeforeYear")
//    public List<Movie> getMoviesBeforeYear(@RequestParam(value = "year") int year) {
//        List<Movie> movies = repo.findByYearLessThan(year);
//        return movies;
//    }
}