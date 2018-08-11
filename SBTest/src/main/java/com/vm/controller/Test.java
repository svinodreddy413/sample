/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.vm.EsmeStatus;
import com.vm.beans.BlockingQueueResp;
import com.vm.beans.CheckInfo;
import com.vm.beans.CheckInfoResp;
import com.vm.beans.CttResponse;
import com.vm.beans.EsmeData;
import com.vm.beans.EsmeList;
import com.vm.beans.EsmeReq;
import com.vm.beans.EsmeResp;
import com.vm.beans.EsmeSessionInfo;
import com.vm.beans.EsmeToggelResp;
import com.vm.beans.IncomingQueueResp;
import com.vm.beans.OutgoingQueueResp;
import com.vm.beans.UploadResponse;
import com.vm.beans.User;
import com.vm.beans.UserResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author VINODH
 */
@RestController
@RequestMapping("/api")
public class Test {

    Map<String, String> tokenMap = new HashMap<>();

    @RequestMapping(method = RequestMethod.POST, path = "/auth", produces = MediaType.APPLICATION_JSON)
    public Response authenticate(@RequestBody @Validated User user) {
        System.out.println("Authenticate : User Name : " + user.getUsername());
        return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity("SUCCESS").build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/authenticate", produces = MediaType.APPLICATION_JSON)
    public UserResponse auth(@RequestBody @Validated User user) {
        System.out.println("Auth: User Name : " + user.getUsername());
        UserResponse resp = new UserResponse();

        String token = null;
        token = Jwts.builder().setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        resp.setUsername(user.getUsername());
        resp.setPassword(user.getPassword());

        tokenMap.put("USER_TOKEN", token);
        resp.setToken(token);
        return resp;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/esme/status", produces = MediaType.APPLICATION_JSON)
    public List<EsmeStatus> esmeStatus() {
        EsmeStatus info ;
        List<EsmeStatus> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            info = new EsmeStatus("vinod"+i, ""+i, ""+i, "9090", "0.0.0.0", "1", "time", "status", ""+i, "vin");
            list.add(info);
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/incomingQueueInfo", produces = MediaType.APPLICATION_JSON)
    public List<IncomingQueueResp> getIncomingQueueInfo(HttpServletRequest request) {
        System.out.println("Test:getIncomingQueueInfo: ");
        List<IncomingQueueResp> incomingQueueInfoList = new ArrayList<>();
        IncomingQueueResp obj;
        String requestedToken = getToken(request);
        System.out.println("Requested Token : " + requestedToken);
        System.out.println("Actual Token : " + tokenMap.get("USER_TOKEN"));
        if (requestedToken.equals(tokenMap.get("USER_TOKEN"))) {
            System.out.println("Tokens Matched ... ");
            for (int i = 0; i < 100; i++) {
                obj = new IncomingQueueResp("QT_ESME_" + i, "VINOD_" + i, i, 100, 10, i);
                incomingQueueInfoList.add(obj);
            }
            return incomingQueueInfoList;
        } else {
            System.out.println("Test:getIncomingQueueInfo: Invalid Requested Token .");
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/outgoingQueueInfo", produces = MediaType.APPLICATION_JSON)
    public List<OutgoingQueueResp> getOutgoingQueueInfo(HttpServletRequest request) {
        System.out.println("Test:getOutgoingQueueInfo: ");
        List<OutgoingQueueResp> outgoingQueueInfoList = new ArrayList<>();
        OutgoingQueueResp obj;
        String requestedToken = getToken(request);
        System.out.println("Requested Token : " + requestedToken);
        System.out.println("Actual Token : " + tokenMap.get("USER_TOKEN"));
        if (requestedToken.equals(tokenMap.get("USER_TOKEN"))) {
            System.out.println("Tokens Matched ... ");
            for (int i = 0; i < 20; i++) {
                obj = new OutgoingQueueResp("QT_ESME_" + i, "SMSC_OUT_" + i, i, 100, 10, i);
                outgoingQueueInfoList.add(obj);
            }
            return outgoingQueueInfoList;
        } else {
            System.out.println("Test:getOutgoingQueueInfo: Invalid Requested Token .");
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/checkstatusinfo", produces = MediaType.APPLICATION_JSON)
    public List<CheckInfoResp> getCheckStatusInfo(HttpServletRequest request, @RequestBody CheckInfo info) {
        System.out.println("Test:getCheckStatusInfo: ");
        System.out.println("=====================            Check Status Info      ===========================");
        System.out.println("Req : --> " + info.getMobilenumbers());
        System.out.println("Req Obj : --> " + info);
        List<CheckInfoResp> checkInfoRespList = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            checkInfoRespList.add(get(i));
        }
        return checkInfoRespList;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/esmedata", produces = MediaType.APPLICATION_JSON)
    public List<EsmeData> getEsmeData(HttpServletRequest request, @RequestBody EsmeReq info) {
        System.out.println("Test:getCheckStatusInfo: ");
        System.out.println("=====================            Check Status Info      ===========================");
        System.out.println("Req : --> " + info.getLoginuserid());
        System.out.println("Req Obj : --> " + info);
        List<EsmeData> respList = new ArrayList<>();
        EsmeData data;
        for (int i = 1; i <= 15; i++) {
            data = new EsmeData("2" + i, 100 + i);
            respList.add(data);
        }
        return respList;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/esmetoggleresp", produces = MediaType.APPLICATION_JSON)
    public List<EsmeToggelResp> getEsmeToggelResp(HttpServletRequest request, @RequestBody EsmeReq info) {
        System.out.println("Test:getCheckStatusInfo: ");
        System.out.println("=====================            Check Status Info      ===========================");
        System.out.println("Req : --> " + info.getLoginuserid());
        System.out.println("Req Obj : --> " + info);
        List<EsmeToggelResp> respList = new ArrayList<>();
        EsmeToggelResp data;
        for (int i = 1; i <= 5; i++) {
            data = new EsmeToggelResp(21 + i, "IN", 0);
            respList.add(data);
        }
        return respList;
    }

    public CheckInfoResp get(int num) {

        switch (num) {
            case 1:
                return new CheckInfoResp("9963728730", "DND");
            case 2:
                return new CheckInfoResp("9963728731", "DNS");
            case 3:
                return new CheckInfoResp("9963728732", "GLOBAL DND");
            case 4:
                return new CheckInfoResp("9963728733", "DNS");
            default:
                break;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.GET, path = "/blockingqueueinfo", produces = MediaType.APPLICATION_JSON)
    public List<BlockingQueueResp> getBlockingQueueInfo(HttpServletRequest request) {
        System.out.println("Test:getBlockingQueueInfo: ");
        List<BlockingQueueResp> blockingQueueInfoList = new ArrayList<>();
        BlockingQueueResp obj;
        String requestedToken = getToken(request);
        System.out.println("Requested Token : " + requestedToken);
        System.out.println("Actual Token : " + tokenMap.get("USER_TOKEN"));
        if (requestedToken.equals(tokenMap.get("USER_TOKEN"))) {
            System.out.println("Tokens Matched ... ");
            for (int i = 0; i < 100; i++) {
                obj = new BlockingQueueResp("VINOD_" + i, "VM_MSG_" + i, "Hello", "27-02-2018", "ACTIVE");
                blockingQueueInfoList.add(obj);
            }
            return blockingQueueInfoList;
        } else {
            System.out.println("Test:getIncomingQueueInfo: Invalid Requested Token .");
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ctt", produces = MediaType.APPLICATION_JSON)
    public List<CttResponse> getCttInfo(HttpServletRequest request) {
        System.out.println("Test:getCttInfo:");
        String requestedToken = getToken(request);
        System.out.println("Requested Token : " + requestedToken);
        List<CttResponse> list = new ArrayList();
        CttResponse res = null;
        for (int i = 0; i < 100; i++) {
            res = new CttResponse(i, "CMP_ID_" + i, 0, 100 + i, 0, "2018-02-28T00:00:00.000Z", i, "2018-02-28T00:00:00.000Z");
            list.add(res);
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/esmeinfo", produces = MediaType.APPLICATION_JSON)
    public List<EsmeResp> getEsmeInfo(HttpServletRequest request) {
        System.out.println("Test:getEsmeInfo: ");
        List<EsmeResp> esmeInfo = new ArrayList<>();
        EsmeResp esmeResp;
        EsmeSessionInfo sessionInfo;
        String requestedToken = getToken(request);
        System.out.println("Requested Token : " + requestedToken);
        System.out.println("Actual Token : " + tokenMap.get("USER_TOKEN"));
        sessionInfo = new EsmeSessionInfo(123, "IN", 0, "ACTIVE");
        esmeResp = new EsmeResp("VINOD_1", 200, "Un-Bind", sessionInfo);
        esmeInfo.add(esmeResp);
        esmeResp = new EsmeResp("VINOD_1", 300, "Re-Bind", sessionInfo);
        esmeInfo.add(esmeResp);

        for (int i = 0; i < 10; i++) {
            sessionInfo = new EsmeSessionInfo(i, "IN", i, "ACTIVE");
            esmeResp = new EsmeResp("VINOD_" + i, i + 100, "Bind", sessionInfo);
            esmeInfo.add(esmeResp);
        }
        return esmeInfo;

//        if (requestedToken.equals(tokenMap.get("USER_TOKEN"))) {
//            System.out.println("Tokens Matched ... ");
//            for (int i = 0; i < 10; i++) {
//                sessionInfo = new EsmeSessionInfo(i, "IN", i, "ACTIVE");
//                esmeResp = new EsmeResp("VINOD_" + i, i + 100, "Bind", sessionInfo);
//                esmeInfo.add(esmeResp);
//            }
//            return esmeInfo;
//        } else {
//            System.out.println("Test:getIncomingQueueInfo: Invalid Requested Token .");
//            return null;
//        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/esmelist", produces = MediaType.APPLICATION_JSON)
    public List<EsmeList> getEsmeList(HttpServletRequest request) {
        System.out.println("Test:getEsmeInfo: ");
        List<EsmeList> esmeInfo = new ArrayList<>();
        List<EsmeSessionInfo> info = new ArrayList<>();
        EsmeList esmeResp;
        EsmeSessionInfo sessionInfo;
        for (int i = 0; i < 2; i++) {
            sessionInfo = new EsmeSessionInfo(12+i, "IN_"+i, i, "ACTIVE");
            info.add(sessionInfo);
        }

        for (int i = 0; i < 5; i++) {
            sessionInfo = new EsmeSessionInfo(i, "IN", i, "ACTIVE");
            esmeResp = new EsmeList("VINOD_"+i, i, info);
            esmeInfo.add(esmeResp);
        }
        return esmeInfo;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/upload", produces = MediaType.APPLICATION_JSON)
    public UploadResponse uploadFile(HttpServletRequest request,
            @RequestParam("file") MultipartFile uploadfile) throws IOException {
        System.out.println("API:uploadFile:");
        System.out.println("-------------------------------------------------------");
        String str = "";
        StringBuilder buf = new StringBuilder();
        UploadResponse resp = null;
        int i = 0;
        String requestedToken = getToken(request);
        System.out.println("Requested Token : " + requestedToken);
        System.out.println("Actual Token : " + tokenMap.get("USER_TOKEN"));
        if (requestedToken.equals(tokenMap.get("USER_TOKEN"))) {
            System.out.println("Tokens Matched ... ");
            System.out.println("File Name : --> " + uploadfile.getOriginalFilename());
            InputStream stream = uploadfile.getInputStream();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                if (stream != null) {
                    while ((str = reader.readLine()) != null) {
                        System.out.println("Line Data : ---------------------> \n" + str);
                        buf.append(str + "\n");
                        i++;
                    }
                    resp = new UploadResponse("SUCCESS", i, "111" + i);
                }
            } finally {
                try {
                    stream.close();
                } catch (Throwable ignore) {
                }
            }
        }
        System.out.println("-------------------------------------------------------");
        return resp;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/upload/multi", produces = MediaType.APPLICATION_JSON)
    public String uploadFileMulti(
            @RequestParam("extraField") String extraField,
            @RequestParam("files") MultipartFile[] uploadfiles) {

        System.out.println("API:uploadFileMulti:");
        System.out.println("Files Size : ----------> " + uploadfiles.length);

        return "SUCCESS";
    }

    @PostMapping("/post")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        System.out.println("==========================================================================");
        try {
            System.out.println("File :----------> " + file);
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    public String getToken(HttpServletRequest request) {
        System.out.println("Test:getToken:");
        String authHeader = getAuthHeaderFromHeader(request);
        System.out.println("Auth Header : --> " + authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    public String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user", produces = MediaType.APPLICATION_JSON)
    public User getUser() {
        System.out.println("Test:getUser:");
        User user = new User();
        user.setUsername("vinod");
        user.setPassword("vinodreddy");
        return user;
    }

}
