package com.item.entity;

import java.util.Date;

public class ItemStorage {
    private String id;

    private String itemName;

    private Integer itemStorage;

    private String itemStaus;

    private Date docCreateTime;

    private String docCreateId;

    private String docCreateName;

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