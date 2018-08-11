/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.vm.beans.User;
import com.vm.beans.UserResponse;
import com.vm.beans.smt.AuthResponse;
import com.vm.beans.smt.InQReq;
import com.vm.beans.smt.InQResponse;
import com.vm.beans.smt.ManageQResponse;
import com.vm.beans.smt.OutQResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author VINODH
 */
@RestController
@RequestMapping("/v1/api")
public class SmtController {

    Map<String, String> tokenMap = new HashMap<>();

    @RequestMapping(method = RequestMethod.POST, path = "/auth/validateuser", produces = MediaType.APPLICATION_JSON)
    public AuthResponse auth(@RequestBody @Validated User user) {
        System.out.println("Auth: User Name : " + user.getUsername());

        AuthResponse resp = new AuthResponse();
        String token = null;
        token = Jwts.builder().setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        resp.setUserName(user.getUsername());
        resp.setUserId(1);
        tokenMap.put("USER_TOKEN", token);
        resp.setToken(token);

        return resp;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/queues/in/all", produces = MediaType.APPLICATION_JSON)
    public List<InQResponse> getInQInfo(@RequestBody @Validated InQReq req) {
        System.out.println("--------------------      IN_Q      --------------------------------------" + req.getLoginuserid());
        List<InQResponse> list = new ArrayList<>();
        InQResponse res = null;
        for (int i = 0; i < 5; i++) {
            res = new InQResponse("QT_SERVER_ESME_" + 1, "" + i, "500" + i, "100" + i, "100" + i, "admin", "10" + i, "20" + i);
            list.add(res);
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/queues/out/all", produces = MediaType.APPLICATION_JSON)
    public List<OutQResponse> getOutQInfo(@RequestBody @Validated InQReq req) {
        System.out.println("--------------------      OUT_Q      --------------------------------------" + req.getLoginuserid());
        List<OutQResponse> list = new ArrayList<>();
        OutQResponse res = null;
        for (int i = 0; i < 5; i++) {
            res = new OutQResponse("QT_SERVER_ESME_" + 1, "" + i, "500" + i, "100" + i, "100" + i, "admin");
            list.add(res);
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/queues/manage/all", produces = MediaType.APPLICATION_JSON)
    public List<ManageQResponse> getManageQInfo(@RequestBody @Validated InQReq req) {
        System.out.println("--------------------      MANAGE_Q      --------------------------------------" + req.getLoginuserid());
        List<ManageQResponse> list = new ArrayList<>();
        ManageQResponse res = null;
        for (int i = 0; i < 5; i++) {
            res = new ManageQResponse("QT_SERVER_ESME_" + 1, "" + i, "500" + i, "100" + i);
            list.add(res);
        }
        return list;
    }

}
