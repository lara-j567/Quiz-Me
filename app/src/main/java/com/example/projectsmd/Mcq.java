package com.example.projectsmd;

import java.io.Serializable;

public class Mcq implements Serializable {

    private String statement;
    private String option1;
    private String option2;
    private String option3;
    private String option4;


    public Mcq(){

        this.statement = "null";
        this.option1 = "null";
        this.option2 = "null";
        this.option3 = "null";
        this.option4 = "null";


    }

    public Mcq(String statement, String option1, String option2, String option3, String option4) {
        this.statement = statement;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }


    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
