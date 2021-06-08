package com.example.euro2020chamionattable.controllers;


import com.example.euro2020chamionattable.sevice.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groupStage")
public class GroupStageController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping
    public String getGroups(Model model){
        return "groups";
    }
}
