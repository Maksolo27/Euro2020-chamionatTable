package com.example.euro2020chamionattable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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

    @Column(name = "concededGoals")
    private int concededGoals;

    @Column(name = "champinatGroup")
    @Enumerated(value = EnumType.STRING)
    private Group group;

    @Column(name = "isplaying")
    private boolean isPlaying;

    @Column(name = "scoreingroup")
    private int scoreInGroup;

    @Column(name = "nextgamewith")
    private int nextGameWith;

    @Column(name = "placeingroup")
    private int placeInGroup;

}
