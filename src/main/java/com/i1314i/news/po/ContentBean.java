package com.i1314i.news.po;

import java.util.List;

public class ContentBean<T> {
    private News news;
    private List<T> hot;
    private List<T> newsOfTime;//最新
    private String type;
    private News lastnew;
    private News nextnew;
    int count ;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public News getLastnew() {
        return lastnew;
    }

    public void setLastnew(News lastnew) {
        this.lastnew = lastnew;
    }

    public News getNextnew() {
        return nextnew;
    }

    public void setNextnew(News nextnew) {
        this.nextnew = nextnew;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

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
}
