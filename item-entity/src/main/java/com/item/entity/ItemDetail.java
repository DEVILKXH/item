package com.item.entity;

import java.util.Date;

public class ItemDetail {
    private String id;

    private String itemName;

    private Integer itemNumber;

    private String itemStorage;

    private Date docCreateTime;

    private String docMainId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

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