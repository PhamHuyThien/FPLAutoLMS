/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class Account {

    private Server server;
    private String cookie;
    private String username;
    private String password;
    private String name;
    private String id;
    private String sex;
    private String role;
    private String birthday;
    private String email;

    public Account() {
    }

    public Account(Server server, String cookie) {
        this.server = server;
        this.cookie = cookie;
    }

    public Account(Server server, String cookie, String username, String password, String name, String id, String sex, String role, String birthday, String email) {
        this.server = server;
        this.cookie = cookie;
        this.username = username;
        this.password = password;
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.role = role;
        this.birthday = birthday;
        this.email = email;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        if(this.email == null){
            return null;
        }
        return email.replace("@fpt.edu.vn", "");
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" + "server=" + server + ", cookie=" + cookie + ", username=" + username + ", password=" + password + ", name=" + name + ", id=" + id + ", sex=" + sex + ", role=" + role + ", birthday=" + birthday + ", email=" + email + '}';
    }

}
