/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author VINODH
 */
@RestController
@RequestMapping("/api/sms")
@Api(value="onlinestore", description="SMS Operations")
public class SmsController {
    
    @ApiOperation(value = "Test Method", response = Response.class)
    @RequestMapping(method = RequestMethod.PUT, path = "/getsms/{message}", consumes = MediaType.TEXT_PLAIN, produces = MediaType.TEXT_PLAIN)
    public String getInfo(@PathVariable String message) {
        //String json = "success";
        System.out.println("Req msg : "+message);
        return "Message updated successfully";
    }
    
    @ApiOperation(value = "Get Messages Info", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Messages"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/getmessages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Map<String, String>> get() {
        Map json = new HashMap<>();
        json.put("User 1", "Message 1");
        json.put("User 2", "Message 2");
        json.put("User 3", "Message 3");
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/modemreq", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN)
    public String getModemResonse(@RequestParam("sender") String sender, @RequestParam("message") String message) {
        System.out.println("Sender : "+sender);
        System.out.println("Message : "+message);
        return "SUCCESS";
    }
    
}
