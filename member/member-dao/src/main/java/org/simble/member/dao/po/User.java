package org.simble.member.dao.po;

import java.io.Serializable;

public class User implements Serializable {
    /**
     *PK
     */
    private String id;

    /**
     *用户名
     */
    private String username;

    /**
     *登陆密码
     */
    private String loginPwd;

    /**
     *用户状态
     */
    private String userStatus;

    private static final long serialVersionUID = 1L;

    /**
     *PK
     */
    public String getId() {
        return id;
    }

    /**
     *PK
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     *用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     *用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     *登陆密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     *登陆密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     *用户状态
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     *用户状态
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
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
            && (this.getLoginPwd() == null ? other.getLoginPwd() == null : this.getLoginPwd().equals(other.getLoginPwd()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getLoginPwd() == null) ? 0 : getLoginPwd().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        return result;
    }
}