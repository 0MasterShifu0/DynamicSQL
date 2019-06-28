package com.mon.project.model.dynamicSQL.vo;

public class Operator {
    private Long id;
    private String dates;
    private String equpment;
    private String operators;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getEqupment() {
        return equpment;
    }

    public void setEqupment(String equpment) {
        this.equpment = equpment;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }
}
