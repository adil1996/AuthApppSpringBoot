package com.forskills.authentication.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Valid;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Valid
public class TestCreateRequest {

    int testId;
    String testName;
    String [] testAllowedIds;
    String expirationDate;

    public TestCreateRequest() {
    }

    public TestCreateRequest(int testId, String testName, String[] testAllowedIds, String expirationDate) {
        this.testId = testId;
        this.testName = testName;
        this.testAllowedIds = testAllowedIds;
        this.expirationDate = expirationDate;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String[] getTestAllowedIds() {
        return testAllowedIds;
    }

    public void setTestAllowedIds(String[] testAllowedIds) {
        this.testAllowedIds = testAllowedIds;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
