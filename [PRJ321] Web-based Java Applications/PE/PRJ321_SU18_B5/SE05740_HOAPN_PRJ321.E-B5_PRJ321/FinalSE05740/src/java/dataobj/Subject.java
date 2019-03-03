/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobj;

import java.sql.Date;

/**
 *
 * @author Thaycacac
 */
public class Subject {

    private int suid;
    private int seid;
    private String sub;
    private int cre;
    private Date date;
    private boolean active;

    public Subject() {
    }

    public Subject(int suid, int seid, String sub, int cre, Date date, boolean active) {
        this.suid = suid;
        this.seid = seid;
        this.sub = sub;
        this.cre = cre;
        this.date = date;
        this.active = active;
    }

    public int getSuid() {
        return suid;
    }

    public void setSuid(int suid) {
        this.suid = suid;
    }

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getCre() {
        return cre;
    }

    public void setCre(int cre) {
        this.cre = cre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }}

