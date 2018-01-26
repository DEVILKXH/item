package com.item.entity;

import com.item.base.entity.BaseEntity;
import com.item.base.entity.annotation.Example;

public class MainTemplate extends BaseEntity{

	@Example
    private String templateId;

	@Example
    private String templateInfo;
    
	@Example
    private String userId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(String templateInfo) {
        this.templateInfo = templateInfo == null ? null : templateInfo.trim();
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}