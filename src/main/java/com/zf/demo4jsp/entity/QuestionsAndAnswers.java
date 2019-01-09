package com.zf.demo4jsp.entity;

import java.util.Date;

public class QuestionsAndAnswers {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.userid
     *
     * @mbggenerated
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.questions
     *
     * @mbggenerated
     */
    private String questions;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.answers
     *
     * @mbggenerated
     */
    private String answers;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.questionsname
     *
     * @mbggenerated
     */
    private String questionsname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.answersname
     *
     * @mbggenerated
     */
    private String answersname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.answersnametype
     *
     * @mbggenerated
     */
    private Integer answersnametype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.causetype
     *
     * @mbggenerated
     */
    private Integer causetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questionsandanswers.clicks
     *
     * @mbggenerated
     */
    private Integer clicks;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    public QuestionsAndAnswers(Integer id, String userid, String questions, String answers, Date createtime, String questionsname, String answersname, Integer answersnametype, Integer causetype, Integer clicks) {
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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    public QuestionsAndAnswers() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.id
     *
     * @return the value of questionsandanswers.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.id
     *
     * @param id the value for questionsandanswers.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.userid
     *
     * @return the value of questionsandanswers.userid
     *
     * @mbggenerated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.userid
     *
     * @param userid the value for questionsandanswers.userid
     *
     * @mbggenerated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.questions
     *
     * @return the value of questionsandanswers.questions
     *
     * @mbggenerated
     */
    public String getQuestions() {
        return questions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.questions
     *
     * @param questions the value for questionsandanswers.questions
     *
     * @mbggenerated
     */
    public void setQuestions(String questions) {
        this.questions = questions == null ? null : questions.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.answers
     *
     * @return the value of questionsandanswers.answers
     *
     * @mbggenerated
     */
    public String getAnswers() {
        return answers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.answers
     *
     * @param answers the value for questionsandanswers.answers
     *
     * @mbggenerated
     */
    public void setAnswers(String answers) {
        this.answers = answers == null ? null : answers.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.createTime
     *
     * @return the value of questionsandanswers.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.createTime
     *
     * @param createtime the value for questionsandanswers.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.questionsname
     *
     * @return the value of questionsandanswers.questionsname
     *
     * @mbggenerated
     */
    public String getQuestionsname() {
        return questionsname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.questionsname
     *
     * @param questionsname the value for questionsandanswers.questionsname
     *
     * @mbggenerated
     */
    public void setQuestionsname(String questionsname) {
        this.questionsname = questionsname == null ? null : questionsname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.answersname
     *
     * @return the value of questionsandanswers.answersname
     *
     * @mbggenerated
     */
    public String getAnswersname() {
        return answersname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.answersname
     *
     * @param answersname the value for questionsandanswers.answersname
     *
     * @mbggenerated
     */
    public void setAnswersname(String answersname) {
        this.answersname = answersname == null ? null : answersname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.answersnametype
     *
     * @return the value of questionsandanswers.answersnametype
     *
     * @mbggenerated
     */
    public Integer getAnswersnametype() {
        return answersnametype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.answersnametype
     *
     * @param answersnametype the value for questionsandanswers.answersnametype
     *
     * @mbggenerated
     */
    public void setAnswersnametype(Integer answersnametype) {
        this.answersnametype = answersnametype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.causetype
     *
     * @return the value of questionsandanswers.causetype
     *
     * @mbggenerated
     */
    public Integer getCausetype() {
        return causetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.causetype
     *
     * @param causetype the value for questionsandanswers.causetype
     *
     * @mbggenerated
     */
    public void setCausetype(Integer causetype) {
        this.causetype = causetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questionsandanswers.clicks
     *
     * @return the value of questionsandanswers.clicks
     *
     * @mbggenerated
     */
    public Integer getClicks() {
        return clicks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questionsandanswers.clicks
     *
     * @param clicks the value for questionsandanswers.clicks
     *
     * @mbggenerated
     */
    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }
}