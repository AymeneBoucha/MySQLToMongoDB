package com.example.MySqlToMongoDb.PC;

import com.example.MySqlToMongoDb.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PcRepository extends JpaRepository<Pc, Long> {

    List<Pc> findByCpuContainingAndNameEndingWithOrderById(String cpu,String name);
    List<Pc> findByStockageGreaterThanAndRamGreaterThanEqual(Integer stockage, Integer ram);
    List<Pc> findPcsByNameStartingWith(String name);

    List<Pc> findPcsByNameEqualsAndRamIsGreaterThanEqualAndStockageIsGreaterThanEqual(String name, Integer ram, Integer stockage) ;

    List<Pc> findTopByStockage(Integer stockage) ;

    List<Pc> findAllByCpuContainingAndNameEndingWithAndRamIsGreaterThan(String cpu, String name, Integer ram);

}
