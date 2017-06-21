package com.record.pojo;

public class School {
    private String schoolid;

    private String schoolname;

    private String schoolcollege;

    private String schoolmajor;

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid == null ? null : schoolid.trim();
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getSchoolcollege() {
        return schoolcollege;
    }

    public void setSchoolcollege(String schoolcollege) {
        this.schoolcollege = schoolcollege == null ? null : schoolcollege.trim();
    }

    public String getSchoolmajor() {
        return schoolmajor;
    }

    public void setSchoolmajor(String schoolmajor) {
        this.schoolmajor = schoolmajor == null ? null : schoolmajor.trim();
    }
}