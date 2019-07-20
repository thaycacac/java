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
public class Article {

    private int id;
    private String title;
    private String imgLink;
    private String content;
    private String fullContent;

    public Article() {

    }

    public Article(int id, String title, String imgLink, String content, String fullContent) {
        this.id = id;
        this.title = title;
        this.imgLink = imgLink;
        this.content = content;
        this.fullContent = fullContent;
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

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    

    
}
