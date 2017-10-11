package com.song.test;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.Document;

import java.net.UnknownHostException;

/**
 * Created by lenovo on 2017/10/11.
 */
public class TestMongdb {
    public static void main(String[] args) {

        try {
            //链接服务
            MongoClient mongoClient  = new MongoClient("localhost",27017 );

            //链接数据库

            DB test = mongoClient.getDB("test");
            DBCollection collection = test.getCollection("test");

            System.out.println("------"+collection);
            DBObject one = collection.findOne();
            System.out.println(one.toString());
            //查询所有文档  需要进行遍历
            DBCursor dbObjects = collection.find();
            for (DBObject d : dbObjects){
                System.out.println(d.toString());
            }

            //条件查询



            MongoDatabase data = mongoClient.getDatabase("test");
            MongoCollection<Document> coll = data.getCollection("test");
            FindIterable<Document> documents = coll.find();
            System.out.println("============");
           for (Document doc:documents){
               System.out.println(doc.toString());
           }
            BSONObject obj = new BasicBSONObject();
            obj.put("name","song");
            FindIterable<Document> documents1 = coll.find();
           // DBCursor dbObjects1 = collection.find((DBObject) obj);
            //System.out.println(dbObjects1.toString());
            System.out.println("-----------------------------------------");

            BasicDBObject basicDBObject = new BasicDBObject();
            basicDBObject.put("name","song");
            DBCursor dbObjects2 = collection.find(basicDBObject);
            for (DBObject db : dbObjects2 ){
                System.out.println(db.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
