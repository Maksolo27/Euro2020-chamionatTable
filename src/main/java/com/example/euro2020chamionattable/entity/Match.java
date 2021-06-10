package com.example.euro2020chamionattable.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "matches")
@Data
@NoArgsConstructor
@ToString
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "championatgroup")
    @Enumerated(value = EnumType.STRING)
    private Group championatGroup;
    @Column(name = "firsteamid")
    private int firstTeamId;
    @Column(name = "firsteamgoals")
    private int firstTeamGoals;
    @Column(name = "secondteamgoals")
    private int secondTeamGoals;
    @Column(name = "secondteamid")
    private int secondTeamId;
    @Column(name = "matchdate")
    private String matchDate;


}
