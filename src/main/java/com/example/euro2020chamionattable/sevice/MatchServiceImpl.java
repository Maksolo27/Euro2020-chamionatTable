package com.example.euro2020chamionattable.sevice;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Match;
import com.example.euro2020chamionattable.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MatchServiceImpl implements MatchService{

    @Autowired
    private MatchRepository matchRepository;


    public List<Match> getAll(){
        return matchRepository.findAll();
    }

    @Override
    public Match add(Match match) {
        return matchRepository.saveAndFlush(match);
    }

    @Override
    public List<Match> getTeamsByGroup(Group group) {
        return matchRepository.findMatchesByChampionatGroup(group);
    }
}
