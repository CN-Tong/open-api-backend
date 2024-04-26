package com.tong.openapi.service.impl;

import com.tong.openapi.service.UserInterfaceInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


// @SpringBootTest
class UserInterfaceInfoServiceImplTest {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void testInvokeOneCount(){
        boolean success = userInterfaceInfoService.invokeOneCount(23L, 1783390440930672642L);
        Assertions.assertTrue(success);
    }

}