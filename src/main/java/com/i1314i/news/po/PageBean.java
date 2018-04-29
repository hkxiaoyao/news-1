package com.i1314i.news.po;

import java.util.List;

public class PageBean<T> {
    private int pagecode;//当前页码
    private int totalpage;//总页数
    private int totalrecord;//总记录数
    private int pagesize;//每页记录数
    private List<T> beanList; //当前页记录
    private int typeid;
    private List<T> hot;
    private List<T> newsOfTime;//最新

    public List<T> getHot() {
        return hot;
    }

    public void setHot(List<T> hot) {
        this.hot = hot;
    }

    public List<T> getNewsOfTime() {
        return newsOfTime;
    }

    public void setNewsOfTime(List<T> newsOfTime) {
        this.newsOfTime = newsOfTime;
    }

    private String typename;

    public int getTypeid() {
        return typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getPagecode() {
        return pagecode;
    }

    public void setPagecode(int pagecode) {
        this.pagecode = pagecode;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalrecord() {
        return totalrecord;
    }

    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
