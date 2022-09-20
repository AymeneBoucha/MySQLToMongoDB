package com.example.MySqlToMongoDb.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll = null;

    List<User> findByFirstNameEndingWithAndAgeGreaterThan(String firstName, Integer age) ;

    List<User> findByAgeIsLikeAndEmailIsContaining(Integer age, String email);

    List<User> findUserByAgeEqualsAndEmailIsContainingOrderByAge(Integer age, String email);

    List<User> findUserByAgeBetween(Integer min, Integer max) ;

    List<User> findUserByIdIsGreaterThanAndAgeEquals(Long id, Integer age) ;

    List<User> findFirstByAgeEqualsAndEmailStartingWith(Integer age, String email) ;

    List<User> findUserByIdIsGreaterThanAndEmailContainingAndFirstNameStartingWithAndLastNameEndingWith(Long id, String email, String fn, String ln);

}
