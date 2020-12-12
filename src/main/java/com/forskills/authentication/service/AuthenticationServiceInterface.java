package com.forskills.authentication.service;

import com.forskills.authentication.dto.AuthrnticationRequest;
import com.forskills.authentication.dto.TestCreateRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

public interface AuthenticationServiceInterface {

    HashMap<String,String> fetchUserDetails(String email) throws Exception;
    HashMap<String,String> SaveUserDeatils(@RequestBody AuthrnticationRequest authrnticationRequest) throws Exception;
    HashMap<String,String> createTest(@RequestBody TestCreateRequest testCreateRequest) throws Exception;
}
