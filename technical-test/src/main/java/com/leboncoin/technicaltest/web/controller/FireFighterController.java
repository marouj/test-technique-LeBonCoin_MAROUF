package com.leboncoin.technicaltest.web.controller;

import com.leboncoin.technicaltest.dao.TeamDaoI;
import com.leboncoin.technicaltest.model.FireFighter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
public class FireFighterController {

    @Autowired
    private TeamDaoI teamDao;



    @ApiOperation(value = "Récupère le FireFighter du jour.")
    @RequestMapping(value = "/FireFighter/new", method = RequestMethod.GET)
    public FireFighter currentFireFighter() {
        return teamDao.getCurrentDev(LocalDate.now());

    }


    @ApiOperation(value = "Récupére un FireFighter avec son ID.")
    @RequestMapping(value = "/FireFighter/{id}", method = RequestMethod.GET)
    public FireFighter getFireFighterById(@PathVariable int id) {
        return teamDao.fireFighterDao(id);

    }

    @ApiOperation(value = "Récupére la liste des FireFighters.")
    @RequestMapping(value = "/FireFighter/", method = RequestMethod.GET)
    public List<FireFighter> getFireFighters() {
        return teamDao.findAll();

    }


    @ApiOperation(value = "Rajoute un nouveau développeur à l'équipe puis renvoie le FireFighter du jour.")
    @PostMapping("/FireFighter/new")
    public ResponseEntity<String> addFireFighter( @RequestBody FireFighter fireFighter) {
        FireFighter f = teamDao.addFireFighter(fireFighter, LocalDate.now());
        // Check if Dev is added
        if(f == null){
            // Return http error with message
            return ResponseEntity
                    .status(HttpStatus.FAILED_DEPENDENCY).body("L'ajout d'un nouveau développeur à échoué.");
        }
        // Else display fireFighter of the day
        return ResponseEntity.ok(f.toString());
    }





}
