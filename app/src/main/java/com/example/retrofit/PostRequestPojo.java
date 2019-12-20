package com.example.retrofit;

public class PostRequestPojo {
    private int userid;
    private Integer id;
    private  String title;
    private String body;

    public PostRequestPojo(int userid,  String title, String body) {
        this.userid = userid;
        this.title = title;
        this.body = body;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
