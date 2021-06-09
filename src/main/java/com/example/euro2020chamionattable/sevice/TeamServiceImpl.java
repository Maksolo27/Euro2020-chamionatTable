package com.example.euro2020chamionattable.sevice;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Team;
import com.example.euro2020chamionattable.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamRepository teamRepository;


    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team getById(int id) {
        return teamRepository.getById(id);
    }

    @Override
    public Team getByName(String name) {
        return teamRepository.getByName(name);
    }

    @Override
    public List<Team> getTeamsByGroup(Group group) {
        return teamRepository.getTeamsByGroup(group);
    }
}
