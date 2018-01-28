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
    private String docContent;
    
    @Example
    private String readFlag;
    
    @Example
    private String docCreatorId;
    
    @Example
    private String docCreatorName;

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

    public String getDocContent() {
		return docContent;
	}

	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}

	public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag == null ? null : readFlag.trim();
    }

	public String getDocCreatorId() {
		return docCreatorId;
	}

	public void setDocCreatorId(String docCreatorId) {
		this.docCreatorId = docCreatorId;
	}

	public String getDocCreatorName() {
		return docCreatorName;
	}

	public void setDocCreatorName(String docCreatorName) {
		this.docCreatorName = docCreatorName;
	}
    
}