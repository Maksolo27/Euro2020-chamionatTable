package com.example.euro2020chamionattable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "nationalteam")
@NoArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "scoredgoals")
    private int scoredGoals;

    @Column(name = "concededgoals")
    private int concededGoals;

    @Column(name = "champinatgroup")
    @Enumerated(value = EnumType.STRING)
    private Group group;

    @Column(name = "isplaying")
    private boolean isPlaying;

    @Column(name = "scoreingroup")
    private int scoreInGroup;

    @Column(name = "placeingroup")
    private int placeInGroup;

    @Column(name = "numberofmatches")
    private int numberOfMatches;

}
