package com.example.othregensburg.zapp;

// TODO (2) Change to Room Entity (with annotation @Entity and proper table name)
// TODO (3) Add member variable id as Primary Key and let it generate automatically
// TODO (4) Move this class to package "db"

// TODO (5) Craete a DAO class (@Dao) "StaffDao" with methods for @Insert, @Delete and @Query



public class StaffMember {

    private String firstName;
    private String lastName;
    private String role;

    public StaffMember(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
