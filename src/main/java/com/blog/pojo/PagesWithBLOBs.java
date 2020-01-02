package com.blog.pojo;

public class PagesWithBLOBs extends Pages {
    private String md;

    private String html;

    public PagesWithBLOBs(Integer id, String type, String md, String html) {
        super(id, type);
        this.md = md;
        this.html = html;
    }

    public PagesWithBLOBs() {
        super();
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md == null ? null : md.trim();
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }
}