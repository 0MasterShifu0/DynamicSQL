package com.mon.project.model.dynamicSQL.controller;

import com.mon.project.model.dynamicSQL.dao.DynamicSqlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/curDynamicSql")
public class CurDynamicSqlContorller {
    private static final Logger logger = LoggerFactory.getLogger(CurDynamicSqlContorller.class);
    @Autowired
    DynamicSqlDao dynamicSqlDao;

    @RequestMapping(value = "/findByDynamicSqlGetReturn/{tableName}",method = RequestMethod.GET)
    public List<Map<String,Object>> findByDynamicSqlGetReturn(@PathVariable("tableName") String tableName){
        logger.info("查询开始");
        Map<String,Object> map=new HashMap<String, Object>();
        List<Map<String,Object>> return_cursor = new ArrayList<>();

        map.put("tableName",tableName);
        map.put("return_cursor",return_cursor);
        dynamicSqlDao.findByDynamicSql(map);
        logger.info("查询结果--------------"+map.get("return_cursor").toString());
        return (List<Map<String, Object>>) map.get("return_cursor");
    }
}
