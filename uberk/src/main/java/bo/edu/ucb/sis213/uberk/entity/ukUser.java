package bo.edu.ucb.sis213.uberk.entity;

import java.util.Date;
import java.util.Objects;


public class ukUser {
    private Integer userId;
    private String user_name;
    private String name;
    private String last_name;
    private String password;
    private String email;
    private String phone;
    private Boolean status;
    private String txUsername;
    private String txHost;
    private Date txDate;

    public ukUser(){

    }

    public ukUser(Integer userId, String user_name, String name, String last_name, String password, String email, String phone, Boolean status, String txUsername, String txHost, Date txDate) {
        this.userId = userId;
        this.user_name = user_name;
        this.name = name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.txUsername = txUsername;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTxUsername() {
        return txUsername;
    }

    public void setTxUsername(String txUsername) {
        this.txUsername = txUsername;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "ukUser{" +
                "userId=" + userId +
                ", user_name='" + user_name + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", txUsername='" + txUsername + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ukUser ukUser = (ukUser) o;
        return Objects.equals(userId, ukUser.userId) && Objects.equals(user_name, ukUser.user_name) && Objects.equals(name, ukUser.name) && Objects.equals(last_name, ukUser.last_name) && Objects.equals(password, ukUser.password) && Objects.equals(email, ukUser.email) && Objects.equals(phone, ukUser.phone) && Objects.equals(status, ukUser.status) && Objects.equals(txUsername, ukUser.txUsername) && Objects.equals(txHost, ukUser.txHost) && Objects.equals(txDate, ukUser.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, user_name, name, last_name, password, email, phone, status, txUsername, txHost, txDate);
    }
}
