package com.example.MySqlToMongoDb.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAll  = null;

    List<Project> findProjectsByNameContaining(String name) ;

    List<Project> findProjectsByParticipantsNbEquals(Integer nb) ;

    List<Project> findProjectsByParticipantsNbGreaterThanAndDurationMonthsGreaterThan(Integer nb, Integer dur) ;

    List<Project> findProjectsByIdGreaterThanAndNameEndingWith(Long id, String name) ;

    List<Project> findTopByDurationMonthsOrderById(Integer dur) ;

    List<Project> findFirstByDurationMonthsEquals(Integer dur) ;

}
