package com.item.entity;

import java.util.Date;

import com.item.base.entity.annotation.Example;

public class SysLoginLog {

	@Example
	private String logId;

	@Example
    private String sessionId;

	@Example
    private String userId;

	@Example
    private String userName;

	@Example
    private String ip;

	@Example
    private Date lastestLoginTime;

	@Example
    private Date lastestLogoutTime;

	@Example
    private String state;

	@Example
    private Date createTime;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getLastestLoginTime() {
        return lastestLoginTime;
    }

    public void setLastestLoginTime(Date lastestLoginTime) {
        this.lastestLoginTime = lastestLoginTime;
    }

    public Date getLastestLogoutTime() {
        return lastestLogoutTime;
    }

    public void setLastestLogoutTime(Date lastestLogoutTime) {
        this.lastestLogoutTime = lastestLogoutTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}