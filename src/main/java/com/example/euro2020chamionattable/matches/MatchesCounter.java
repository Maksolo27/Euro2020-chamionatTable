package com.example.euro2020chamionattable.matches;

import java.util.*;
import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Match;
import com.example.euro2020chamionattable.entity.Team;
import com.example.euro2020chamionattable.sevice.MatchServiceImpl;
import com.example.euro2020chamionattable.sevice.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchesCounter {

    @Autowired
    private TeamServiceImpl teamService;
    @Autowired
    private MatchServiceImpl matchService;


    public void updateGroupResults(Group group){
        List<Match> matchList = matchService.getMatchesByGroup(group);
        for (int i = 0; i < matchList.size(); i++) {
            calculateMatchScore(matchList.get(i));
        }
    }

    private void calculateMatchScore(Match match) {
        Team firstTeam = teamService.getById(match.getFirstTeamId());
        Team secondTeam = teamService.getById(match.getSecondTeamId());
        if(match.getFirstTeamGoals() > match.getSecondTeamGoals()){
            firstTeam.setScoreInGroup(firstTeam.getScoreInGroup() + 3);
            secondTeam.setScoreInGroup(secondTeam.getScoreInGroup() + 0);
        }
        if(match.getFirstTeamId() < match.getSecondTeamId()){
            firstTeam.setScoreInGroup(firstTeam.getScoreInGroup() + 0);
            secondTeam.setScoreInGroup(secondTeam.getScoreInGroup() + 3);
        }
        if(match.getFirstTeamGoals() == match.getSecondTeamGoals()){
            firstTeam.setScoreInGroup(firstTeam.getScoreInGroup() + 1);
            secondTeam.setScoreInGroup(secondTeam.getScoreInGroup() + 1);
        }
        teamService.update(firstTeam);
        teamService.update(secondTeam);
    }
}
