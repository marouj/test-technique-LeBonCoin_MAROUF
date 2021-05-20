package com.leboncoin.technicaltest.dao;

import com.leboncoin.technicaltest.model.FireFighter;

import java.time.LocalDate;
import java.util.List;


public interface TeamDao {
     List<FireFighter> findAll();
     FireFighter fireFighterDao(int id);
     FireFighter getCurrentDev(LocalDate d);
     FireFighter addFireFighter(FireFighter f,LocalDate d);

}
