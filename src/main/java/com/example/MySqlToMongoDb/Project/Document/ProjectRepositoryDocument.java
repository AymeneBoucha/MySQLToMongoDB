package com.example.MySqlToMongoDb.Project.Document;

import com.example.MySqlToMongoDb.Project.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepositoryDocument extends MongoRepository<ProjectDocument, Long> {

    List<ProjectDocument> findAll  = null;

    List<ProjectDocument> findProjectsByNameContaining(String name) ;

    List<ProjectDocument> findProjectsByParticipantsNbEquals(Integer nb) ;

    List<ProjectDocument> findProjectsByParticipantsNbGreaterThanAndDurationMonthsGreaterThan(Integer nb, Integer dur) ;

    List<ProjectDocument> findProjectsByIdGreaterThanAndNameEndingWith(Long id, String name) ;

    List<ProjectDocument> findTopByDurationMonthsOrderById(Integer dur) ;

    List<ProjectDocument> findFirstByDurationMonthsEquals(Integer dur) ;


}
