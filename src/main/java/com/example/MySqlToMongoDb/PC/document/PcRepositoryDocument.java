package com.example.MySqlToMongoDb.PC.document;

import com.example.MySqlToMongoDb.PC.Pc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PcRepositoryDocument extends MongoRepository<PcDocument, Long> {

    List<PcDocument> findByCpuContainingAndNameEndingWithOrderById(String cpu, String name);

    List<PcDocument> findByStockageGreaterThanAndRamGreaterThanEqual(Integer stockage, Integer ram);

    List<PcDocument> findPcsByNameStartingWith(String name);
    List<PcDocument> findPcsByNameEqualsAndRamIsGreaterThanEqualAndStockageIsGreaterThanEqual(String name, Integer ram, Integer stockage) ;

    List<PcDocument> findTopByStockage(Integer stockage) ;

    List<PcDocument> findPcsByCpuContainingAndNameEndingWithAndRamIsGreaterThan(String cpu, String name, Integer ram);


}
