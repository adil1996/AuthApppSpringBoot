package com.forskills.authentication.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.Valid;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Valid
public class AuthrnticationRequest {

    String email;
    String firstName;
    String lastNamw;
    String password;

    public AuthrnticationRequest() {
    }

    public AuthrnticationRequest(String email, String firstName, String lastNamw, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastNamw = lastNamw;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNamw() {
        return lastNamw;
    }

    public void setLastNamw(String lastNamw) {
        this.lastNamw = lastNamw;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
