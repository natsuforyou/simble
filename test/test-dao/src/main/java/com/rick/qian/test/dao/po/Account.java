/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.dao.po;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    /**
     *主键
     */
    private String id;

    /**
     *账号
     */
    private String accoutNo;

    /**
     *用户id
     */
    private String userId;

    /**
     *状态
     */
    private String status;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
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
     *账号
     */
    public String getAccoutNo() {
        return accoutNo;
    }

    /**
     *账号
     */
    public void setAccoutNo(String accoutNo) {
        this.accoutNo = accoutNo == null ? null : accoutNo.trim();
    }

    /**
     *用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     *用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     *状态
     */
    public String getStatus() {
        return status;
    }

    /**
     *状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     *创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *更新时间
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
        Account other = (Account) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccoutNo() == null ? other.getAccoutNo() == null : this.getAccoutNo().equals(other.getAccoutNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccoutNo() == null) ? 0 : getAccoutNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}