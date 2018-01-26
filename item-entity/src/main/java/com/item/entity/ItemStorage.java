package com.item.entity;

import java.util.Date;

import com.item.base.entity.BaseEntity;
import com.item.base.entity.annotation.Example;

public class ItemStorage extends BaseEntity{

	@Example
    private String itemName;

	@Example
    private Integer itemStorage;

	@Example
    private String itemStaus;

	@Example
    private Date docCreateTime;

	@Example
    private String docCreateId;

	@Example
    private String docCreateName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getItemStorage() {
        return itemStorage;
    }

    public void setItemStorage(Integer itemStorage) {
        this.itemStorage = itemStorage;
    }

    public String getItemStaus() {
        return itemStaus;
    }

    public void setItemStaus(String itemStaus) {
        this.itemStaus = itemStaus == null ? null : itemStaus.trim();
    }

    public Date getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(Date docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getDocCreateId() {
        return docCreateId;
    }

    public void setDocCreateId(String docCreateId) {
        this.docCreateId = docCreateId == null ? null : docCreateId.trim();
    }

    public String getDocCreateName() {
        return docCreateName;
    }

    public void setDocCreateName(String docCreateName) {
        this.docCreateName = docCreateName == null ? null : docCreateName.trim();
    }
}