package com.example.euro2020chamionattable.repository;

import com.example.euro2020chamionattable.entity.Group;
import com.example.euro2020chamionattable.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.*;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>, CrudRepository<Match, Integer> {

    List<Match> findMatchesByChampionatGroup(Group group);


}
