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
            //���ӷ���
            MongoClient mongoClient  = new MongoClient("localhost",27017 );

            //�������ݿ�

            DB test = mongoClient.getDB("test");
            DBCollection collection = test.getCollection("test");

            System.out.println("------"+collection);
            DBObject one = collection.findOne();
            System.out.println(one.toString());
            //��ѯ�����ĵ�  ��Ҫ���б���
            DBCursor dbObjects = collection.find();
            for (DBObject d : dbObjects){
                System.out.println(d.toString());
            }

            //������ѯ



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
