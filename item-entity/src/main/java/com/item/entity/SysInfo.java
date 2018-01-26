package com.item.entity;

import java.util.Date;

import com.item.base.entity.BaseEntity;
import com.item.base.entity.annotation.Example;

public class SysInfo extends BaseEntity{
	
    @Example
	private String docSubject;
    
    @Example
    private Date docCreatime;
    
    @Example
    private String readFlag;

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject == null ? null : docSubject.trim();
    }

    public Date getDocCreatime() {
        return docCreatime;
    }

    public void setDocCreatime(Date docCreatime) {
        this.docCreatime = docCreatime;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag == null ? null : readFlag.trim();
    }
}