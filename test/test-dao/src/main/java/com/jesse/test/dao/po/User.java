/*
 * ©2016 Jesse. some rights reserved.
 */
package com.jesse.test.dao.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     *主键
     */
    private String id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String realName;

    /**
     *
     */
    private String status;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     *主键
     */
    public String getId() {
        return id;
    }

    /**
     *主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     *
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     *
     */
    public String getRealName() {
        return realName;
    }

    /**
     *
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}