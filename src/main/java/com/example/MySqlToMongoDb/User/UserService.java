package com.example.MySqlToMongoDb.User;

import com.example.MySqlToMongoDb.PC.Pc;
import com.example.MySqlToMongoDb.PC.PcService;
import com.example.MySqlToMongoDb.PC.document.PcDocument;
import com.example.MySqlToMongoDb.User.UserDocument.UserDocument;
import com.example.MySqlToMongoDb.User.UserDocument.UserRepositoryDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements InitializingBean {

    static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryDocument userRepositoryDocument;


    @Override
    public void afterPropertiesSet() throws Exception {

        /*List <User> users = userRepository.findByFirstNameEndingWithAndAgeGreaterThan("n", 20);
        * List <UserDocument> usersD = userRepositoryDocument.findByFirstNameEndingWithAndAgeGreaterThan("n", 20);*/

        /*List <User> users = userRepository.findByAgeIsLikeAndEmailIsContaining(90, "e@g");
        * List <UserDocument> usersD = userRepositoryDocument.findByAgeIsLikeAndEmailIsContaining(90, "e@g");*/

        /*List<User> users = userRepository.findUserByAgeEqualsAndEmailIsContainingOrderByAge(25, "bb");
        * List<UserDocument> usersD = userRepositoryDocument.findUserByAgeEqualsAndEmailIsContainingOrderByAge(25, "bb");*/

        /*List<User> users = userRepository.findAll();
        * List<UserDocument> usersD = userRepositoryDocument.findAll();*/

        /*List<User> users = userRepository.findUserByAgeBetween(25, 35) ;
        * List<UserDocument> usersD = userRepositoryDocument.findUserByAgeBetween(25, 35) ;*/

        /*List<User> users = userRepository.findUserByIdIsGreaterThanAndAgeEquals(10000L, 18) ;
         *List<User> usersD = userRepositoryDocument.findUserByIdIsGreaterThanAndAgeEquals(10000L, 18) ; */

        /*List<User> users = userRepository.findFirstByAgeEqualsAndEmailStartingWith(26, "hh") ;
         *List<UserDocument> usersD = userRepositoryDocument.findFirstByAgeEqualsAndEmailStartingWith(26, "hh") ;*/

        /*long start = System.currentTimeMillis();
        List<User> users = userRepository.findUserByIdIsGreaterThanAndEmailContainingAndFirstNameStartingWithAndLastNameEndingWith(100L, "c@", "d", "e");
        long time = System.currentTimeMillis() - start;
        System.out.println("\t" + users.size()+ "\n");
        System.out.println("\n" + "The execution time for MySql is : " + time + "\n");


        long startD = System.currentTimeMillis();
        List<UserDocument> usersD = userRepositoryDocument.findUserByIdIsGreaterThanAndEmailContainingAndFirstNameStartingWithAndLastNameEndingWith(100L, "c@", "d", "e");
        long timeD = System.currentTimeMillis() - startD;
        System.out.println("\t" + usersD.size()+ "\n");
        System.out.println("The execution time for MongoDb is : " + timeD + "\n");*/

        List<User> users = userRepository.findAll();
        userRepositoryDocument.saveAll(users.stream()
                        .map(user -> new UserDocument(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge()))
                        .collect(Collectors.toSet()));
    }
}
