package com.example.euro2020chamionattable.controllers;


import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Team;
import com.example.euro2020chamionattable.sevice.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/groupStage")
public class GroupStageController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping
    public String getGroups(Model model){
        List<Team> teamList = teamService.getAll();
        model.addAttribute("group_A", teamList.stream().filter(x -> x.getGroup().equals(Group.A)).collect(Collectors.toList()));
        model.addAttribute("group_B", teamList.stream().filter(x -> x.getGroup().equals(Group.B)).collect(Collectors.toList()));
        model.addAttribute("group_C", teamList.stream().filter(x -> x.getGroup().equals(Group.C)).collect(Collectors.toList()));
        model.addAttribute("group_D", teamList.stream().filter(x -> x.getGroup().equals(Group.D)).collect(Collectors.toList()));
        model.addAttribute("group_E", teamList.stream().filter(x -> x.getGroup().equals(Group.E)).collect(Collectors.toList()));
        model.addAttribute("group_F", teamList.stream().filter(x -> x.getGroup().equals(Group.F)).collect(Collectors.toList()));
        return "groupStage";
    }
}
