package com.sistema.alunos.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sistema.alunos.model.Course;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Filters.regex;

@Component
public class SearchImplementation implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Course> findByText(String text) {

        List<Course> courses = new ArrayList<>();

        MongoDatabase database = client.getDatabase(Dotenv.load().get("DBNAME"));
        MongoCollection<Document> collection = database.getCollection("User");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                match(or(
                        regex("course", text, "i"),
                        regex("institution", text, "i")
                )),
                new Document("$sort", new Document("workload", 1L))
        ));



        result.forEach(doc -> {
            courses.add(converter.read(Course.class, doc));
        });


        return courses;
    }
}
