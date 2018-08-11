/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.vm.beans.xml.Err;
import com.vm.beans.xml.Guid;
import com.vm.beans.xml.MessageReq;
import com.vm.beans.xml.MessageResp;
import com.vm.beans.xml.sms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
@RequestMapping("/api/data")
@Api(value="onlinestore", description="Operations related to the Mobile Messaging")
public class TestController {

    private Marshaller marshaller = null;

    public TestController() {
        try {

            JAXBContext pduLogJc = JAXBContext.newInstance(MessageResp.class);
            marshaller = pduLogJc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "Test Method", response = Response.class)
    @RequestMapping(method = RequestMethod.GET, path = "/test", produces = MediaType.APPLICATION_JSON)
    public Response test() {
        String json = "success";
        return Response.status(Status.OK).type(MediaType.APPLICATION_JSON).entity(json).build();
    }

    @ApiOperation(value = "Test VM Data.", response = ResponseEntity.class)
    @RequestMapping(value = "/testvm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity testVM() {
        String json = "success";
        return new ResponseEntity(json, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Info from Map obj", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Map"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Map<String, String>> get() {
        Map json = new HashMap<>();
        json.put("vinod", "Test");
        json.put("vinod1", "Test1");
        json.put("vinod2", "Test2");
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @ApiOperation(value = "Pushes the Messages to the specified msisdns.", response = MessageResp.class)
    @RequestMapping(path = "/sms", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML, consumes = MediaType.APPLICATION_XML)
    public MessageResp sms(@RequestBody @Validated MessageReq request) throws HttpMessageNotReadableException {
        System.out.println("Req : --> "+request);
        System.out.println("Excep Testing ...");
        try {
            //logger.info("[TIBCO] MessageReq:[{}]", request);
            String result = "OK";
            if ("OK".equalsIgnoreCase(result)) {
                sms sms = request.getSms().get(0);
                String messageId = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
                return sendResponce("OK", sms.getId(), messageId, "919440649402");
            } else {
                return sendResponce(result, "0", "", "");
            }
        } catch (Exception e) {
            throw new HttpMessageNotReadableException("Could not read XML: " + e.getMessage(),e);
        }
    }

    private MessageResp sendResponce(String result, String id, String messageId, String msisdn) {
        String buffer = "";
        MessageResp resp = new MessageResp();
        Guid gui = new Guid();
        Err err = new Err();
        try {
            if (result.equalsIgnoreCase("OK")) {
                gui.setGuid(messageId);
                gui.setId(id); //new DateTime().toString(MyUtils.datezFormatInMils())
                //gui.setSubmitDate(new DateTime().toString(MyUtils.datezFormatInMils())); // new DateTime().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"))
                List<Guid> list = new ArrayList<>();
                list.add(gui);
                resp.setGuid(list);
            } else if (result.equalsIgnoreCase("InvalidCredentials") || result.equalsIgnoreCase("InvalidPassword")) {
                err.setCode("52992");
                err.setDesc("Username / Password incorrect");
                resp.setErr(err);
            } else if (result.equalsIgnoreCase("DestinationEmpty")) {
                err.setCode("28674");
                err.setDesc("Destination number empty");
                resp.setErr(err);
            } else if (result.equalsIgnoreCase("DestinationNotNumeric")) {
                err.setCode("28673");
                err.setDesc("Destination number not numeric");
                resp.setErr(err);
            } else if (result.equalsIgnoreCase("SenderIdEmpty")) {
                err.setCode("28675");
                err.setDesc("Sender address empty");
                resp.setErr(err);
            } else if (result.equalsIgnoreCase("InvalidSenderID")) {
                err.setCode("28680");
                err.setDesc("Invalid Sender ID");
                resp.setErr(err);
            } else if (result.equalsIgnoreCase("EmptyText")) {
                err.setCode("28679");
                err.setDesc("SMS text is empty");
                resp.setErr(err);
            } else if (result.equalsIgnoreCase("InvalidCoding")) {
                err.setCode("28678");
                err.setDesc("Coding is invalid");
                resp.setErr(err);
            } else {
                err.setCode("999");
                err.setDesc(result);
                resp.setErr(err);
            }
            //logger.info("[TIBCO] [{}] Send responce to client..", msisdn);
            //if (logger.isTraceEnabled()) {
            StringWriter sw = new StringWriter();
            marshaller.marshal(resp, sw);
            buffer = sw.toString();
            //logger.trace("[TIBCO] Entering Into sms resp: {}", buffer);
            //}

        } catch (Exception e) {
            //logger.error("[TIBCO] Excep:NiSmsApi:sendResponce:Error:{}", ExceptionUtils.getStackTrace(e));
            buffer = "<MESSAGEACK>\n"
                    + "<Err Code=\"999\" Desc=\"Invalid XML recevied.\"/>\n"
                    + "</MESSAGEACK>";
        }
        return resp;
    }
    
    

}
