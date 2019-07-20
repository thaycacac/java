/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author thuongnnse05095
 */
public class Home {

    private int id;
    private String type;
    private String title;
    private String imgLink;
    private String content;
    private String author;
    private String createDate;
    private String titleGroup;

    public Home(int id, String type, String title, String imgLink, String content, String author, String createDate) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.imgLink = imgLink;
        this.content = content;
        this.author = author;
        this.createDate = createDate;
    }

    public Home(int id, String type, String title, String imgLink, String content, String author, String createDate, String titleGroup) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.imgLink = imgLink;
        this.content = content;
        this.author = author;
        this.createDate = createDate;
        this.titleGroup = titleGroup;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitleGroup() {
        return titleGroup;
    }

    public void setTitleGroup(String titleGroup) {
        this.titleGroup = titleGroup;
    }

}
