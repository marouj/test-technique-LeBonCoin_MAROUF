package com.leboncoin.technicaltest.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamTests {
    @Test
    void updateCurrentFireFighterTest() {

        ArrayList<FireFighter> fireFighters = new ArrayList<>();

        fireFighters.add(new FireFighter(1, "User1", "Core Qualité"));
        fireFighters.add(new FireFighter(2, "User2", "Core Qualité"));
        fireFighters.add(new FireFighter(3, "User3", "Android"));

        // Input Data
        Team team = new Team(fireFighters, LocalDate.now());

        // Expected result
        String exptectedResult ="{id=2, nom='User2', team='Core Qualité'}";

        // Result
        String result = team.updateCurrentFireFighter(LocalDate.now().plusDays(1)).toString();

        // Verify
        assertEquals(exptectedResult, result,
                "Creation FireFighter Test");
    }

    @Test
    void addDevTest() {

        ArrayList<FireFighter> fireFighters = new ArrayList<>();

        fireFighters.add(new FireFighter(1, "User1", "Core Qualité"));
        fireFighters.add(new FireFighter(2, "User2", "Core Qualité"));
        fireFighters.add(new FireFighter(3, "User3", "Android"));
        int size = fireFighters.size();


        // Input Data
        Team team = new Team(fireFighters, LocalDate.now());
        team.addDev(new FireFighter(4, "User4", "Android"));


        // expected result
        int exptectedResult = size +1 ;

        // result
        int result = team.getDevs().size();

        // Verify
        assertEquals(exptectedResult, result,
                "Add FireFighter to team Test");
    }

    @Test
    void addDevWithWrongInputDataTest() {

        ArrayList<FireFighter> fireFighters = new ArrayList<>();

        fireFighters.add(new FireFighter(1, "User1", "Core Qualité"));
        fireFighters.add(new FireFighter(2, "User2", "Core Qualité"));
        fireFighters.add(new FireFighter(3, "User3", "Android"));

        int size = fireFighters.size();

        // Input Data
        Team team = new Team(fireFighters, LocalDate.now());
        team.addDev(new FireFighter(1, "User1", "Android"));

        // expected result
        int exptectedResult = size ;

        // result
        int result = team.getDevs().size();

        // Verify
        assertEquals(exptectedResult, result,
                "Add FireFighter with wrong input data to team Test");
    }

}
