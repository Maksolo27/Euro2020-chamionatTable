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
        Set<Match> matches = new HashSet<>();
        List<Match> matchList = new ArrayList<>(matches);
        for (Match match : matchList) {
            Match duplicatedMatch = new Match();
            duplicatedMatch.setChampionatGroup(group);
            duplicatedMatch.setFirstTeamId(match.getSecondTeamId());
            duplicatedMatch.setSecondTeamId(match.getFirstTeamId());
            if(matchList.contains(duplicatedMatch)){
                matchList.remove(match);
            }
        }
        System.out.println(matchList);
        addToDatabase(new HashSet<>(matchList));
        return matchSet;
    }

    private void addToDatabase(Set<Match> matchSet){
        Iterator<Match> matchSetiterator = matchSet.iterator();
        while (matchSetiterator.hasNext()){
            matchService.add(matchSetiterator.next());
        }
    }
}
