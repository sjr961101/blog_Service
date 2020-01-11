package com.blog.pojo;

public class sysLog {
    private Integer id;

    private Integer time;

    private String ip;

    private String content;

    public sysLog(Integer id, Integer time, String ip, String content) {
        this.id = id;
        this.time = time;
        this.ip = ip;
        this.content = content;
    }

    public sysLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}