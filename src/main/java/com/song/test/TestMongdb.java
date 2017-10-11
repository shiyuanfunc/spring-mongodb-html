package com.song.test;

import com.mongodb.*;

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

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
