package com.zf.demo4jsp.entity;

public class HotAsk {
    private Integer id;

    private String problem;

    private String answer;

    private Integer testcount;

    private Integer evaluatecount;

    private String evaluate;

    public HotAsk(Integer id, String problem, String answer, Integer testcount, Integer evaluatecount, String evaluate) {
        this.id = id;
        this.problem = problem;
        this.answer = answer;
        this.testcount = testcount;
        this.evaluatecount = evaluatecount;
        this.evaluate = evaluate;
    }

    public HotAsk() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getTestcount() {
        return testcount;
    }

    public void setTestcount(Integer testcount) {
        this.testcount = testcount;
    }

    public Integer getEvaluatecount() {
        return evaluatecount;
    }

    public void setEvaluatecount(Integer evaluatecount) {
        this.evaluatecount = evaluatecount;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }
}