package com.forskills.authentication.service;

import com.forskills.authentication.dto.AuthrnticationRequest;
import com.forskills.authentication.dto.TestCreateRequest;
import com.forskills.authentication.model.TestDetails;
import com.forskills.authentication.model.UserDetails;
import com.forskills.authentication.repo.TestDetailsRepo;
import com.forskills.authentication.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationServiceInterface {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Autowired
    TestDetailsRepo testDetailsRepo;

    @Override
    public HashMap<String, String> fetchUserDetails(String email) throws Exception {
        try{
            UserDetails userDetails = userDetailsRepo.findByEmail(email);
            List<UserDetails> userDetailsList = userDetailsRepo.findAll();
            HashMap<String,String> users = new HashMap<>();
            users.put("email",userDetails.getEmail());
            users.put("password",userDetails.getPassword());
            return users;
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public HashMap<String, String> SaveUserDeatils(AuthrnticationRequest authrnticationRequest) throws Exception {
        try{
            UserDetails userDetails = new UserDetails();
            userDetails.setEmail(authrnticationRequest.getEmail());
            userDetails.setFirstName(authrnticationRequest.getFirstName());
            userDetails.setLastName(authrnticationRequest.getLastNamw());
            userDetails.setPassword(authrnticationRequest.getPassword());
            userDetailsRepo.save(userDetails);
            HashMap<String,String> user = new HashMap<>();
            user.put("Status","Success");
            return user;
        }
        catch (Exception ex){
            throw  ex;
        }
    }

    @Override
    public HashMap<String, String> createTest(TestCreateRequest testCreateRequest) throws Exception {
        try{
            TestDetails testDetails = new TestDetails();
            testDetails.setTestId(testCreateRequest.getTestId());
            testDetails.setTestName(testCreateRequest.getTestName());
            testDetails.setAllowedEmail(Arrays.asList(testCreateRequest.getTestAllowedIds()).stream().map( e -> e.trim()).collect(Collectors.joining(",")));
            testDetails.setDate(testCreateRequest.getExpirationDate());
            testDetailsRepo.save(testDetails);
            HashMap<String,String> test = new HashMap<>();
            test.put("Status","Success");
            return test;
        }
        catch (Exception ex){
            throw ex;
        }
    }
}
