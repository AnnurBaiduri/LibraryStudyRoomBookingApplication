package com.example.bottomnav.ui.about;

public class Teammate {
    private int imageResId;
    private String fullName;
    private String studentID;
    private String programName;
    private String role;
    private String groupName;  // New field for the group name

    public Teammate(int imageResId, String fullName, String studentID, String programName, String role, String groupName) {
        this.imageResId = imageResId;
        this.fullName = fullName;
        this.studentID = studentID;
        this.programName = programName;
        this.role = role;
        this.groupName = groupName;
    }

    // Getter for the image resource ID
    public int getImageResId() {
        return imageResId;
    }

    // ... Other existing getters
    public String getFullName() {
        return fullName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getProgramName() {
        return programName;
    }

    public String getRole() {
        return role;
    }

    // Getter for the group name
    public String getGroupName() {
        return groupName;
    }
}