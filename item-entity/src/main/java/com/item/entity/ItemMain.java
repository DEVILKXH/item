package com.item.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.item.base.dto.TemplateInfo;
import com.item.base.entity.BaseEntity;
import com.item.base.entity.annotation.Example;
import com.item.utils.StringUtil;

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
	
	private Template template;
	
	private TemplateInfo tempInfo;
	
	private String tempInfoJSON;
	
	private List<ItemDetail> fdItems;

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

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public List<ItemDetail> getFdItems() {
		return fdItems;
	}

	public void setFdItems(List<ItemDetail> fdItems) {
		this.fdItems = fdItems;
	}

	public TemplateInfo getTempInfo() {
		if(null == tempInfo && tempInfoJSON != null){
			tempInfo  =JSONObject.parseObject(tempInfoJSON, TemplateInfo.class);
		}
		return tempInfo;
	}

	public void setTempInfo(TemplateInfo tempInfo) {
		this.tempInfo = tempInfo;
		if(null != tempInfo){
			this.tempInfoJSON = JSONObject.toJSONString(tempInfo);
		}
	}

	public String getTempInfoJSON() {
		if(StringUtil.isNull(tempInfoJSON) && null != tempInfo){
			tempInfoJSON = JSONObject.toJSONString(tempInfo);
		}
		return tempInfoJSON;
	}

	public void setTempInfoJSON(String tempInfoJSON) {
		this.tempInfoJSON = tempInfoJSON;
	}
}