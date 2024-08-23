package com.tdp.ct.web.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JDBCOperations {

    @Autowired
    public Select select;
    @Autowired
    public Insert insert;
    @Autowired
    public Update update;
    @Autowired
    public Delete delete;
    @Autowired
    public Utility context;

}