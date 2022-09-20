package com.example.MySqlToMongoDb.PC;

import com.example.MySqlToMongoDb.PC.document.PcDocument;
import com.example.MySqlToMongoDb.PC.document.PcRepositoryDocument;
import com.example.MySqlToMongoDb.User.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PcService implements InitializingBean {
    static final Logger LOGGER = LoggerFactory.getLogger(PcService.class);

    @Autowired
    private PcRepository pcRepository;
    @Autowired
    private PcRepositoryDocument pcRepositoryDocument;


    @Override
    public void afterPropertiesSet() throws Exception {


        /*List<Pc> pcs = pcRepository.findAll();
        List<PcDocument> pcsD = pcRepositoryDocument.findAll();*/

        /*List <Pc> pcs = pcRepository.findByCpuContainingAndNameEndingWithOrderById("5", "us");
        List <PcDocument> pcsD = pcRepositoryDocument.findByCpuContainingAndNameEndingWithOrderById("5","us");*/

        /*List <Pc> pcs = pcRepository.findByStockageGreaterThanAndRamGreaterThanEqual(500, 8);
        List <PcDocument> pcsD = pcRepositoryDocument.findByStockageGreaterThanAndRamGreaterThanEqual(500, 8);*/

        /*List <Pc> pcs = pcRepository.findPcsByNameStartingWith("A");
        *List <PcDocument> pcsD = pcRepositoryDocument.findPcsByNameStartingWith("A"); */

        /*List<Pc> pcs = pcRepository.findPcsByNameEqualsAndRamIsGreaterThanEqualAndStockageIsGreaterThanEqual("Asus", 8, 1024) ;
        *List <PcDocument> pcsD = pcRepositoryDocument.findPcsByNameEqualsAndRamIsGreaterThanEqualAndStockageIsGreaterThanEqual("Asus", 8, 1024) ;         */

        /* List<Pc> pcs = pcRepository.findTopByStockage(2048) ;
        *List<PcDocument> pcsD = pcRepositoryDocument.findTopByStockage(2048) ; */

        /*long start = System.currentTimeMillis();
        List<Pc> pcs = pcRepository.findAllByCpuContainingAndNameEndingWithAndRamIsGreaterThan("7", "i", 16) ;
        long time = System.currentTimeMillis() - start;
        System.out.println("\t" + pcs.size() + "\n");
        System.out.println("\n" + "The execution time for MySql is : " + time + "\n");


        long startD = System.currentTimeMillis();
        List<PcDocument> pcsD = pcRepositoryDocument.findPcsByCpuContainingAndNameEndingWithAndRamIsGreaterThan("7", "i", 16) ;
        long timeD = System.currentTimeMillis() - startD;
        System.out.println("\t" + pcsD.size() + "\n");
        System.out.println("The execution time for MongoDb is : " + timeD + "\n");*/


        List<Pc> pcs = pcRepository.findAll();
        pcRepositoryDocument.saveAll(
                pcs.stream()
                        .map(pc -> new PcDocument(pc.getId(), pc.getName(), pc.getCpu(), pc.getRam(), pc.getStockage()))
                        .collect(Collectors.toSet()));
    }
}
