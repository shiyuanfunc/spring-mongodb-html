package com.song.test;

import com.mongodb.*;

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

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
