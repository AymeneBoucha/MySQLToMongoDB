package com.example.MySqlToMongoDb.Project;

import com.example.MySqlToMongoDb.Project.Document.ProjectDocument;
import com.example.MySqlToMongoDb.Project.Document.ProjectRepositoryDocument;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements InitializingBean {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectRepositoryDocument projectRepositoryDocument;

    @Override
    public void afterPropertiesSet() throws Exception {

        /*List<Project> projects = projectRepository.findAll();
        List<ProjectDocument> projectsD = projectRepositoryDocument.findAll();*/

        /*List<Project> projects = projectRepository.findProjectsByNameContaining("App");
        List<ProjectDocument> projectsD = projectRepositoryDocument.findProjectsByNameContaining("App");*/

        /*List<Project> projects = projectRepository.findProjectsByParticipantsNbEquals(25);
        *List<ProjectDocument> projectsD = projectRepositoryDocument.findProjectsByParticipantsNbEquals(25);*/

        /*List<Project> projects = projectRepository.findProjectsByParticipantsNbGreaterThanAndDurationMonthsGreaterThan(45, 45);
         List<ProjectDocument> projectsD = projectRepositoryDocument.findProjectsByParticipantsNbGreaterThanAndDurationMonthsGreaterThan(45, 45);*/
        /*List<Project> projects = projectRepository.findProjectsByIdGreaterThanAndNameEndingWith(30000L, "p");
          List<ProjectDocument> projectsD = projectRepositoryDocument.findProjectsByIdGreaterThanAndNameEndingWith(30000L, "p");*/

        /*List<Project> projects = projectRepository.findTopByDurationMonthsOrderById(48);
        * List<ProjectDocument> projectsD = projectRepositoryDocument.findTopByDurationMonthsOrderById(48);*/

        /*long start = System.currentTimeMillis();
        List<Project> projects = projectRepository.findFirstByDurationMonthsEquals(48);
        long time = System.currentTimeMillis() - start;
        System.out.println("\t" + projects.size() + "\n");
        System.out.println("\n" + "The execution time for MySql is : " + time + "\n");

        long startD = System.currentTimeMillis();
        List<ProjectDocument> projectsD = projectRepositoryDocument.findFirstByDurationMonthsEquals(48);
        long timeD = System.currentTimeMillis() - start;
        System.out.println("\t" + projectsD.size() + "\n");
        System.out.println("\n" + "The execution time for MongoDB is : " + timeD + "\n");*/

        List<Project> projects = projectRepository.findAll();
        System.out.println("\t" + projects.size());
        projectRepositoryDocument.saveAll(
                projects.stream().map(project -> new ProjectDocument(project.getId(), project.getName(), project.getParticipantsNb(), project.getDurationMonths(), project.getChef()))
                        .collect(Collectors.toSet()));
    }
}
