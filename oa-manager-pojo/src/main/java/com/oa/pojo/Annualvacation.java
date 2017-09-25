package com.oa.pojo;

import java.util.Date;

public class Annualvacation {
    private Integer id;

    private Integer userid;

    private String year;

    private Integer have;

    private Integer used;

    private Integer remain;

    private Date starttime;

    private Date stoptime;

    private Integer previousremain;

    private Date previousstoptime;

    private Integer total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getHave() {
        return have;
    }

    public void setHave(Integer have) {
        this.have = have;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public Integer getPreviousremain() {
        return previousremain;
    }

    public void setPreviousremain(Integer previousremain) {
        this.previousremain = previousremain;
    }

    public Date getPreviousstoptime() {
        return previousstoptime;
    }

    public void setPreviousstoptime(Date previousstoptime) {
        this.previousstoptime = previousstoptime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}