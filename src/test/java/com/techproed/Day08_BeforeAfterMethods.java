package com.techproed;

import org.junit.*;

public class Day08_BeforeAfterMethods {

    @BeforeClass
    public static void setUp(){
        System.out.println("BeforClass calisti");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("AfterClass calisti");
    }
    @Before
    public  void beforeTest(){
        System.out.println("BeforClass calisti");
    }

    @After
    public  void tearDown(){
        System.out.println("AfterClass calisti");
    }

    @Test
    public void test1(){
        System.out.println("test1 calisti");
    }







}

