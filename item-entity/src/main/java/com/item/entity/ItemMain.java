package com.item.entity;

import java.util.Date;

import com.item.base.entity.BaseEntity;
import com.item.base.entity.annotation.Example;

public class ItemMain extends BaseEntity{
	
	@Example
    private String docSubject;

	@Example
    private String docStatus;

	@Example
    private Date docCreateTime;

	@Example
    private String docCreatorId;

	@Example
    private String docCreateName;

	@Example
    private Date docAlterTime;
	
	@Example
    private String docAlterId;
	
	@Example
    private String docRemark;

	@Example
    private String docAlterName;

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject == null ? null : docSubject.trim();
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus == null ? null : docStatus.trim();
    }

    public Date getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(Date docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getDocCreatorId() {
        return docCreatorId;
    }

    public void setDocCreatorId(String docCreatorId) {
        this.docCreatorId = docCreatorId == null ? null : docCreatorId.trim();
    }

    public String getDocCreateName() {
        return docCreateName;
    }

    public void setDocCreateName(String docCreateName) {
        this.docCreateName = docCreateName == null ? null : docCreateName.trim();
    }

    public Date getDocAlterTime() {
        return docAlterTime;
    }

    public void setDocAlterTime(Date docAlterTime) {
        this.docAlterTime = docAlterTime;
    }

    public String getDocAlterId() {
        return docAlterId;
    }

    public void setDocAlterId(String docAlterId) {
        this.docAlterId = docAlterId == null ? null : docAlterId.trim();
    }

    public String getDocRemark() {
        return docRemark;
    }

    public void setDocRemark(String docRemark) {
        this.docRemark = docRemark == null ? null : docRemark.trim();
    }

    public String getDocAlterName() {
        return docAlterName;
    }

    public void setDocAlterName(String docAlterName) {
        this.docAlterName = docAlterName == null ? null : docAlterName.trim();
    }
}