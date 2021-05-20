package com.leboncoin.technicaltest.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FireFighterTests {

    @Test
    void createFireFighterTest() {
        // Input user
        FireFighter f = new FireFighter(1, "User","Android Team");

        // Expected result
        String exptectedResult ="{id=1, nom='User', team='Android Team'}";

        // Result
        String result = f.toString();

        // Verify
        assertEquals(exptectedResult, result,
                "Creation FireFighter Test");
    }
}
