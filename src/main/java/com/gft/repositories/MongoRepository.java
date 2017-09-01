package com.gft.repositories;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MongoRepository<T extends Entity> implements IRepository<T> {

    private DBCollection items;

    public MongoRepository(String databaseName, String collectionName) throws IOException {
    /*    Properties settings = new Properties();
        settings.load(new FileInputStream("src/main/resources/application.properties"));
        String mongoURI = settings.getProperty("mongodb.uri");
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://pcbl:oL91uQU8R0VzBnhI6T97QDxk0u5Zip3K02wSonncUWb9DVFM7nhEfvA1dmoefRKUphCYbuiY50bWYS9KeKgH3A==@pcbl.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));
        DB database = mongoClient.getDB(databaseName);
        items = database.getCollection(collectionName);*/
    }

    @Override
    public Iterable<T> Items() {
     return null;
    }

    @Override
    public void Add(T instance) {
        Gson gson = new Gson();
        BasicDBObject dbObject = (BasicDBObject) JSON.parse(gson.toJson(instance));
        items.insert(dbObject);
    }

    @Override
    public T GetById(long id) {
        return null;
    }
}
