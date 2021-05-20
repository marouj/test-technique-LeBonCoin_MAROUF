package com.leboncoin.technicaltest.dao;

import com.leboncoin.technicaltest.model.FireFighter;
import com.leboncoin.technicaltest.model.Team;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Repository
public class TeamDaoI implements TeamDao {
    public static ArrayList<FireFighter> fireFighters = new ArrayList<>();
    public static Team team;


    // Simulate database repository
    static {
        fireFighters.add(new FireFighter(1, "Franch", "Core Qualité"));
        fireFighters.add(new FireFighter(2, "Romain", "Core Qualité"));
        fireFighters.add(new FireFighter(3, "Saad", "Android"));
        fireFighters.add(new FireFighter(4, "Renaud", "Core Qualité"));
        fireFighters.add(new FireFighter(5, "Hugo", "Core Qualité"));
        fireFighters.add(new FireFighter(6, "Ilyess", "Core Qualité"));

        team = new Team(fireFighters, LocalDate.now());
    }
    // To get All dev in team
    @Override
    public List<FireFighter> findAll() {
        return fireFighters;
    }

    // Get dev by his id
    @Override
    public FireFighter fireFighterDao(int id) {
        for(FireFighter f : fireFighters){
            if(f.getId() == id){
                return f;
            }
        }
        return null;
    }

    // Get current FireFighter
    @Override
    public FireFighter getCurrentDev(LocalDate d) {
        return team.updateCurrentFireFighter(d);

    }

    // Add dev to team and update current FireFighter
    @Override
    public FireFighter addFireFighter(FireFighter f, LocalDate d) {
        return team.addDev(f) ? team.updateCurrentFireFighter(d) : null ;
    }


}