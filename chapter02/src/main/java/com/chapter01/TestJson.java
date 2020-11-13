package com.chapter01;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class TestJson {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestJson.class);

    public static void main(String[] args) {
//        MDC.put("ok", "right");
//        LOGGER.info("helloWorldhelloWorldhelloWorldhelloWorldhelloWorld");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AGE", 10);
        jsonObject.put("FULL NAME", "Doe");
        jsonObject.put("DATE OF BIRTH", "2016/12/12 12:12:12");

        MDC.put("hi", "123");
        MDC.put("go", "456");
        MDC.put("co", "");
        MDC.put("do", null);

        LOGGER.info(jsonObject.toJSONString());
        try {
            int n = 1 / 0;
        } catch (Exception e) {
            LOGGER.info("error", e);
        }
    }
}
