/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm;

import com.vm.controller.SmsController;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @author VINODH
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = SmsController.class, secure = false)
public class SmsControllerTest {

    //@Autowired
    @Mock
    private MockMvc mockMvc;

    @Test
    public void retrieveDetailsForCourse() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/sms/getsms/vinodmsg").accept(MediaType.TEXT_PLAIN);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("Test Response : --> " + result.getResponse().getContentAsString());
        String expected = "Message updated successfully";
        assertEquals(expected, result.getResponse().getContentAsString());

    }

}
