package com.example.euro2020chamionattable.repository;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>, CrudRepository<Team, Integer> {
    Team getByName(String name);

    List<Team> getTeamsByGroup(Group group);
}
