package com.vm;

import com.vm.controller.SmsController;
import javax.ws.rs.core.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BasicApplicationTests {
//
//	@Test
//	public void contextLoads() {
//	}
//
//}
@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(SmsController.class)
public class BasicApplicationTests {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private SmsController smsController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(smsController)
                .build();

    }

    //com.baeldung.utils.controller.UtilsController;
    @Test
    public void givenParameter_setRequestParam_andSetSessionAttribute() throws Exception {
        String param = "testparam";

//        mvc.perform(getInfo("/getsms")
//                .contentType(MediaType.TEXT_PLAIN))
//                .andExpect(status().isOk());
        
    }

}
