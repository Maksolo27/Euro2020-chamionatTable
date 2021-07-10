package com.example.euro2020chamionattable.controllers;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Match;
import com.example.euro2020chamionattable.entity.Team;
import com.example.euro2020chamionattable.matches.MatchesGenerator;
import com.example.euro2020chamionattable.sevice.MatchServiceImpl;
import com.example.euro2020chamionattable.sevice.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/groupStage/details")
public class DetailsAboutGroupController {

    @Autowired
    private TeamServiceImpl teamService;
    @Autowired
    private MatchesGenerator matchesGenerator;
    @Autowired
    private MatchServiceImpl matchService;

    @GetMapping
    public String getGroups(@RequestParam String group, Model model){
        List<Team> teamList = teamService.getAll();
        List<Match> matchList = matchService.getAll();
        for (int i = 0; i < Group.values().length; i++) {
            if(Group.values()[i].toString().equals(group)) {
                final int j = i;
                model.addAttribute("current_group",
                            teamList.stream().filter(x -> x.getGroup().equals(Group.values()[j])).collect(Collectors.toList()))
                        .addAttribute("current_group_matches",
                            matchList.stream().filter(x -> x.getChampionatGroup().equals(Group.values()[j])).collect(Collectors.toList()));
            }
        }
        return "groupDetails";
    }
}
