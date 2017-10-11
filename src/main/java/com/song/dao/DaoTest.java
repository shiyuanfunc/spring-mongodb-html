package com.song.dao;

import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/10/11.
 */
@Repository
public class DaoTest implements IDaoTest{

    @Autowired
    private MongoTemplate mongoTemplate;

    public void test() throws Exception{
        System.out.println(mongoTemplate);
        DBCollection test = mongoTemplate.getCollection("test");
        long count = test.count();
        System.out.println(count);
        System.out.println(test);

    }
}
