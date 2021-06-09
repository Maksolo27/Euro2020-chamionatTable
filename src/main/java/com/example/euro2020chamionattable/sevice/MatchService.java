package com.example.euro2020chamionattable.sevice;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Match;

import java.util.*;
public interface MatchService {
    List<Match> getAll();

    Match add(Match match);

    List<Match> getTeamsByGroup(Group group);
}
