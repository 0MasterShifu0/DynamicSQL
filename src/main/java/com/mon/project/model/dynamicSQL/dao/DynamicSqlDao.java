package com.mon.project.model.dynamicSQL.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface DynamicSqlDao {

    public void findByDynamicSql(Map<String, Object> seachMap);

}
