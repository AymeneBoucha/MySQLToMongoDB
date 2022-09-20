package com.example.MySqlToMongoDb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MySqlToMongoDbApplication {

    public static void main(String args[]) throws SQLException {
        SpringApplication.run(MySqlToMongoDbApplication.class, args);
    }

/*********************************************************************************************************************************/

    // Second Method

    public static void mainOld(String args[]) throws SQLException {

        //Creating a MongoDB client
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb+srv://TipTopDanger:3456789@cluster0.bryt2.mongodb.net/?retryWrites=true&w=majority");
        MongoClient mongo = new MongoClient(mongoClientURI);
        //Connecting to the database
        MongoDatabase database = mongo.getDatabase("ferobase");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferobase", "root", "root");

        Statement stmt1 = conn.createStatement();
        String sql1 = "show tables";
        ResultSet rs1 = stmt1.executeQuery(sql1);
        while (rs1.next()) {
            System.out.println(rs1.getString(1) + "\n");
            MongoCollection<Document> collection = database.getCollection(rs1.getString(1));
            List<Document> list = new ArrayList<Document>();
            String sql2 = "SHOW COLUMNS FROM ferobase." + rs1.getString(1);
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();
            Statement stmt4 = conn.createStatement();
            String sql4 = "SELECT COUNT(*) FROM " + rs1.getString(1);
            ResultSet rs4 = stmt4.executeQuery(sql4);
            rs4.next();
            Integer count = rs4.getInt(1);
            int i = 0;
            while (i < count) {
                Document document = new Document();
                ResultSet rs2 = stmt2.executeQuery(sql2);
                rs2.next();
                while (rs2.next()) {
                    String sql3 = "SELECT * FROM " + rs1.getString(1) + " LIMIT " + i + ",1";
                    ResultSet rs3 = stmt3.executeQuery(sql3);
                    rs3.next();
                    document.append(rs2.getString(1), rs3.getString(rs2.getString(1)));
                }
                System.out.println(document);
                list.add(document);
                i++;
            }
            if (list.isEmpty() == false) {
                collection.insertMany(list);
            } else {
                collection.insertOne(new Document());
            }
        }

    }
}


