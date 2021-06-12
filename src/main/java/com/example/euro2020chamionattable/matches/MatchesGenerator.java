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
        List<Match> withOutDublicated = withoutDublicated(matchSet, group);
        addToDatabase(new HashSet<>(withOutDublicated));
        return new HashSet<>(withOutDublicated);
    }

    //for national teams matches
    private List<Match> withoutDublicated(Set<Match> matchSet, Group group){
        List<Match> matchList = new ArrayList<>(matchSet);
        List<Match> withOutDublicated = new ArrayList<>(matchList);
        for (Match match : matchList) {
            Match duplicatedMatch = new Match();
            duplicatedMatch.setChampionatGroup(group);
            duplicatedMatch.setFirstTeamId(match.getSecondTeamId());
            duplicatedMatch.setSecondTeamId(match.getFirstTeamId());
            if(withOutDublicated.contains(duplicatedMatch)) {
                withOutDublicated.remove(match);
            }
        }
        return withOutDublicated;
    }

    private void addToDatabase(Set<Match> matchSet){
        Iterator<Match> matchSetiterator = matchSet.iterator();
        while (matchSetiterator.hasNext()){
            matchService.add(matchSetiterator.next());
        }
    }
}
