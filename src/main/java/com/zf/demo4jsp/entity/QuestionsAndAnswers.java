package com.zf.demo4jsp.entity;

import java.util.Date;

public class QuestionsAndAnswers {
    private Integer id;
    private String userid;
    private String questions;
    private String answers;
    private Date createtime;
    private String questionsname;
    private String answersname;
    private Integer answersnametype;
    private Integer  causetype;
    private Integer   clicks;
    public QuestionsAndAnswers(Integer id, String userid, String questions, String answers, Date createtime, String questionsname, String answersname, Integer answersnametype,Integer causetype,Integer clicks) {
        this.id = id;
        this.userid = userid;
        this.questions = questions;
        this.answers = answers;
        this.createtime = createtime;
        this.questionsname = questionsname;
        this.answersname = answersname;
        this.answersnametype = answersnametype;
        this.causetype = causetype;
        this.clicks = clicks;
    }


    public QuestionsAndAnswers() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
    public String getQuestions() {
        return questions;
    }
    public void setQuestions(String questions) {
        this.questions = questions == null ? null : questions.trim();
    }
    public String getAnswers() {
        return answers;
    }
    public void setAnswers(String answers) {
        this.answers = answers == null ? null : answers.trim();
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public String getQuestionsname() {
        return questionsname;
    }
    public void setQuestionsname(String questionsname) {
        this.questionsname = questionsname == null ? null : questionsname.trim();
    }
    public String getAnswersname() {
        return answersname;
    }
    public void setAnswersname(String answersname) {
        this.answersname = answersname == null ? null : answersname.trim();
    }
    public Integer getAnswersnametype() {
        return answersnametype;
    }
    public void setAnswersnametype(Integer answersnametype) {
        this.answersnametype = answersnametype;
    }

    public Integer getCausetype() {
        return causetype;
    }
    public void setCausetype(Integer causetype) {
        this.causetype = causetype;
    }

    public Integer getClicks() {
        return clicks;
    }
    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }
}