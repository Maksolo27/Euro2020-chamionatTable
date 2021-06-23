package com.example.euro2020chamionattable.sevice;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Team;

import java.util.*;

public interface TeamService {

    List<Team> getAll();

    Team getById(int id);

    Team getByName(String name);

    List<Team> getTeamsByGroup(Group group);

    void update(Team team);

}
