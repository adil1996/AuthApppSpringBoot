package com.forskills.authentication.controllers;

import com.forskills.authentication.dto.AuthrnticationRequest;
import com.forskills.authentication.dto.TestCreateRequest;
import com.forskills.authentication.service.AuthenticationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/forskills")
public class AuthController {

    @Autowired
    AuthenticationServiceInterface authenticationServiceInterface;

@GetMapping(
        path = "/getUser/{email}",
        produces = {
                MediaType.APPLICATION_JSON_VALUE
        }
)
public ResponseEntity<HashMap<String,String>> getDetaile(@PathVariable String email){
    try{
        return new ResponseEntity<>(authenticationServiceInterface.fetchUserDetails(email), HttpStatus.OK);
    }
    catch (Exception ex){
        HashMap<String,String> error = new HashMap<>();
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        error.put("message",stringWriter.toString());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@PostMapping(
        path= "/addUser",
        consumes = {
                MediaType.APPLICATION_JSON_VALUE
        },
        produces = {
          MediaType.APPLICATION_JSON_VALUE
}
)
public ResponseEntity<HashMap<String,String>> addUser(@RequestBody AuthrnticationRequest authrnticationRequest) throws Exception{
    try{
        return new ResponseEntity<>(authenticationServiceInterface.SaveUserDeatils(authrnticationRequest), HttpStatus.OK);
    }
    catch (Exception ex){
        HashMap<String,String> error = new HashMap<>();
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        error.put("message",stringWriter.toString());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@PostMapping(
        path = "/addTest",
        consumes = {
                MediaType.APPLICATION_JSON_VALUE
        },
        produces = {
                MediaType.APPLICATION_JSON_VALUE
        }
)
public ResponseEntity<HashMap<String,String>> addTest(@RequestBody TestCreateRequest testCreateRequest) throws Exception{
    try{
        return new ResponseEntity<>(authenticationServiceInterface.createTest(testCreateRequest),HttpStatus.OK);
    }
    catch (Exception ex){
        HashMap<String,String> error = new HashMap<>();
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        error.put("message",stringWriter.toString());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
