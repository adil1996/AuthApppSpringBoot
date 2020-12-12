package com.forskills.authentication.model;

import javax.persistence.*;

@Entity
@Table(name = "TestDetails")
public class TestDetails {


    @Id
    @Column( name = "TestId")
    Integer testId;

    @Column(name = "TestName")
    String testName;

    @Column(name = "ExpiryDate")
    String date;

    @Column(name = "AllowedEmail")
    String allowedEmail;

    public TestDetails() {
    }

    public TestDetails(Integer testId, String testName, String date, String allowedEmail) {
        this.testId = testId;
        this.testName = testName;
        this.date = date;
        this.allowedEmail = allowedEmail;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAllowedEmail() {
        return allowedEmail;
    }

    public void setAllowedEmail(String allowedEmail) {
        this.allowedEmail = allowedEmail;
    }
}
