package com.song.controller;

import com.song.dao.DaoTest;
import com.song.dao.IDaoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2017/10/11.
 */
@Controller
@Scope("prototype")
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IDaoTest daoTest;

    @RequestMapping("/testmongdb")
    public void test() throws Exception{
        daoTest.test();
        System.out.println("ceshi over ");
    }
}
