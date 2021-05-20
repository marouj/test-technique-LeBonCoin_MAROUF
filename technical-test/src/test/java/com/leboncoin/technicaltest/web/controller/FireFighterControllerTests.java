package com.leboncoin.technicaltest.web.controller;

import com.leboncoin.technicaltest.model.FireFighter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FireFighterControllerTests {


    @Autowired
    private MockMvc mvc;

    @Test
    public void getCurrentFireFighter() throws Exception
    {

        mvc.perform( MockMvcRequestBuilders
                .get("/FireFighter/new")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json("{\"id\":1,\"nom\":\"Franch\",\"team\":\"Core Qualité\"}"));

    }

    @Test
    public void addFireFighter() throws Exception
    {

        String inputFireFighterJson = "{\"id\":7,\"nom\":\"UserTestAdd\",\"team\":\"Core Qualité\"}";

        FireFighter expectedFireFighter = new FireFighter(1,"Franch","Core Qualité");

        mvc.perform( MockMvcRequestBuilders
                .post("/FireFighter/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputFireFighterJson)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{id=1, nom='Franch', team='Core Qualité'}"));

    }

    @Test
    public void addFireFighterWithIdAlreadyUsed() throws Exception
    {

        String inputFireFighterJson = "{\"id\":1,\"nom\":\"UserTestAdd\",\"team\":\"Core Qualité\"}";

        FireFighter expectedFireFighter = new FireFighter(1,"Franch","Core Qualité");

        mvc.perform( MockMvcRequestBuilders
                .post("/FireFighter/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputFireFighterJson)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content()
                        .string("L'ajout d'un nouveau développeur à échoué."));

    }


    @Test
    public void addFireFighterWithNameAndTeamAlreadyUsed() throws Exception
    {

        String inputFireFighterJson = "{\"id\":8,\"nom\":\"Saad\",\"team\":\"Android\"}";

        FireFighter expectedFireFighter = new FireFighter(1,"Franch","Core Qualité");

        mvc.perform( MockMvcRequestBuilders
                .post("/FireFighter/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputFireFighterJson)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content()
                        .string("L'ajout d'un nouveau développeur à échoué."));

    }

    @Test
    public void getCurrentFireFighterWithId() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/FireFighter/2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json("{\"id\":2,\"nom\":\"Romain\",\"team\":\"Core Qualité\"}"));

    }
}
