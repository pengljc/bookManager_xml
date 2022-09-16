package com.jxd.book.model;

/**
 * 管理员
 *
 * @ClassName administrator
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/8/31
 * @Version 1.0
 */
public class Admin {
    private int id;
    private String name;
    private String username;
    private String password;
    private int grade;

    public Admin() {
    }

    public Admin(int id, String name, String username, String password, int grade) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                '}';
    }
}
