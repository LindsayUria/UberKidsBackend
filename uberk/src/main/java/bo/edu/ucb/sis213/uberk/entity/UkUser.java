package bo.edu.ucb.sis213.uberk.entity;

import java.util.Date;
import java.util.Objects;
//Es una entidad que toma todos los valores que tiene la tabla que se requiere
//en este caso uk_user

public class UkUser {
    private Integer userId;
    private String username;
    private String name;
    private String lastname;
    private String password;
    private String email;
    private String phone;
    private Boolean status;
    private Date txDate;
    private String txUsername;
    private String txHost;


    public UkUser(){

    }

    public UkUser(Integer userId, String username, String name, String lastname, String password, String email, String phone, Boolean status, Date txDate, String txUsername, String txHost) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.txDate = txDate;
        this.txUsername = txUsername;
        this.txHost = txHost;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
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

    @Override
    public String toString() {
        return "UkUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", txDate=" + txDate +
                ", txUsername='" + txUsername + '\'' +
                ", txHost='" + txHost + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UkUser ukUser = (UkUser) o;
        return Objects.equals(userId, ukUser.userId) && Objects.equals(username, ukUser.username) && Objects.equals(name, ukUser.name) && Objects.equals(lastname, ukUser.lastname) && Objects.equals(password, ukUser.password) && Objects.equals(email, ukUser.email) && Objects.equals(phone, ukUser.phone) && Objects.equals(status, ukUser.status) && Objects.equals(txDate, ukUser.txDate) && Objects.equals(txUsername, ukUser.txUsername) && Objects.equals(txHost, ukUser.txHost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, name, lastname, password, email, phone, status, txDate, txUsername, txHost);
    }
}
