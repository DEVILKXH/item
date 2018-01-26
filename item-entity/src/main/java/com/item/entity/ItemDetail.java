package com.item.entity;

import java.util.Date;

import com.item.base.entity.BaseEntity;
import com.item.base.entity.annotation.Example;

public class ItemDetail extends BaseEntity{

	@Example
    private String itemName;

	@Example
    private Integer itemNumber;

	@Example
    private String itemStorage;
	
	@Example
    private Date docCreateTime;
	
	@Example
    private String docMainId;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemStorage() {
        return itemStorage;
    }

    public void setItemStorage(String itemStorage) {
        this.itemStorage = itemStorage == null ? null : itemStorage.trim();
    }

    public Date getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(Date docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getDocMainId() {
        return docMainId;
    }

    public void setDocMainId(String docMainId) {
        this.docMainId = docMainId == null ? null : docMainId.trim();
    }
}