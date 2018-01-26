package com.item.entity;

import java.util.Date;

import com.item.base.entity.BaseEntity;
import com.item.base.entity.annotation.Example;

public class Template extends BaseEntity{

	@Example
    private String templateName;

	@Example
    private String docCreatorId;

	@Example
    private String docCreatorName;

	@Example
    private Date docCreatime;

	@Example
    private String templateInfo;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getDocCreatorId() {
        return docCreatorId;
    }

    public void setDocCreatorId(String docCreatorId) {
        this.docCreatorId = docCreatorId == null ? null : docCreatorId.trim();
    }

    public String getDocCreatorName() {
        return docCreatorName;
    }

    public void setDocCreatorName(String docCreatorName) {
        this.docCreatorName = docCreatorName == null ? null : docCreatorName.trim();
    }

    public Date getDocCreatime() {
        return docCreatime;
    }

    public void setDocCreatime(Date docCreatime) {
        this.docCreatime = docCreatime;
    }

    public String getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(String templateInfo) {
        this.templateInfo = templateInfo == null ? null : templateInfo.trim();
    }
}