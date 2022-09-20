package com.example.MySqlToMongoDb.User.UserDocument;

import com.example.MySqlToMongoDb.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserRepositoryDocument extends MongoRepository<UserDocument, Long> {

    List<UserDocument> findAll = null;

    List<UserDocument> findByFirstNameEndingWithAndAgeGreaterThan(String firstName, Integer age) ;

    List<UserDocument> findByAgeIsLikeAndEmailIsContaining(Integer age, String email);

    List<UserDocument> findUserByAgeEqualsAndEmailIsContainingOrderByAge(Integer age, String email);

    List<UserDocument> findUserByAgeBetween(Integer min, Integer max) ;

    List<User> findUserByIdIsGreaterThanAndAgeEquals(Long id, Integer age) ;

    List<UserDocument> findFirstByAgeEqualsAndEmailStartingWith(Integer age, String email) ;

    List<UserDocument> findUserByIdIsGreaterThanAndEmailContainingAndFirstNameStartingWithAndLastNameEndingWith(Long id, String email, String fn, String ln);




}
