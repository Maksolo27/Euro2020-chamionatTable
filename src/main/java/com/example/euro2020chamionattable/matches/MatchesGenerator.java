package com.example.euro2020chamionattable.matches;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Match;
import com.example.euro2020chamionattable.entity.Team;
import com.example.euro2020chamionattable.sevice.MatchServiceImpl;
import com.example.euro2020chamionattable.sevice.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.*;

@Component
public class MatchesGenerator {

    @Autowired
    private TeamServiceImpl teamService;
    @Autowired
    private MatchServiceImpl matchService;

    public Set<Match> generateCalendarForGroup(Group group){
        List<Team> teamList = teamService.getTeamsByGroup(group);
        Set<Match> matchSet = new HashSet<>();
        List<Match> allGroupMatches = matchService.getTeamsByGroup(group);
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.size(); j++) {
                if(teamList.get(i).getId() == teamList.get(j).getId()){
                    continue;
                }
                Match match = new Match();
                match.setChampionatGroup(group);
                match.setFirstTeamId(teamList.get(i).getId());
                match.setSecondTeamId(teamList.get(j).getId());
                matchSet.add(match);
            }
        }
        return matchSet;
    }
}
