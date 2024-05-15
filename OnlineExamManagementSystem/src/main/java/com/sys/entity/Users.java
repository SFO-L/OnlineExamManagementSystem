package com.sys.entity;

/**
 * @Author SfO
 * @Version 1.0
 */
public class Users {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private String sex;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Users() {
    }

    public Users(String userName, String password, String email, String sex) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userIdmysql-connector-java-8.0.11.jar=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
