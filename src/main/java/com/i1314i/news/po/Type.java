package com.i1314i.news.po;

import java.util.List;

public class Type {
    private int id;
    private String type;
    private PageBean<News>pageBean;

    public PageBean<News> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<News> pageBean) {
        this.pageBean = pageBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
