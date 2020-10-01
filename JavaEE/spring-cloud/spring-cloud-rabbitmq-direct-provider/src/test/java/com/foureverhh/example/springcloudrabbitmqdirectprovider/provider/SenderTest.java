package com.foureverhh.example.springcloudrabbitmqdirectprovider.provider;

import com.foureverhh.example.springcloudrabbitmqdirectprovider.SpringCloudRabbitmqDirectProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringCloudRabbitmqDirectProviderApplication.class)
public class InfoSenderTest {

    @Autowired
    private InfoSender infoSender;

    @Test
    public void infoSendTest(){
        infoSender.infoSend("Hello from infoSender");
    }
}