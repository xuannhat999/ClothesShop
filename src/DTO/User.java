package DTO;

import java.sql.Date;

public class User {
    private int userId;
    private String fullName;
    private Date dob;
    private String phone;
    private String email;
    private int gender;
    private String address;
    private String username;
    private String password;
    private int roleId;

    public User(){}
    public User(int userId, String fullName, Date dob, String phone, String email, int gender, String address, String username, String password, int roleId) {
        this.userId = userId;
        this.fullName = fullName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public User(User d) {
        this.userId = d.userId;
        this.fullName = d.fullName;
        this.dob = d.dob;
        this.phone = d.phone;
        this.email = d.email;
        this.gender = d.gender;
        this.address = d.address;
        this.username = d.username;
        this.password = d.password;
        this.roleId = d.roleId;
    }



    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getGender() { return gender; }
    public void setGender(int gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getRoleId() { return roleId; }
    public void setRoleId(int roleId) { this.roleId = roleId; }
}
