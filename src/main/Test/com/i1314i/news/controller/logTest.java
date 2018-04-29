package com.i1314i.news.controller;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class logTest {
    private static Logger logger=Logger.getLogger(logTest.class);
    @Test
    public void test1() throws Exception {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}