package com.easy.archiecture.entity;

public class Relation {
    private int id;
    private int mid;
    private int sid;
    private String relation;

    public Relation(int mid, int sid, String relation) {
        this.mid = mid;
        this.sid = sid;
        this.relation = relation;
    }

    public Relation(int id, int mid, int sid, String relation) {
        this.id = id;
        this.mid = mid;
        this.sid = sid;
        this.relation = relation;
    }

    public Relation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
