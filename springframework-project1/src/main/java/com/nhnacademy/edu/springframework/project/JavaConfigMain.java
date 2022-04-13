package com.nhnacademy.edu.springframework.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {
    private static final Log log = LogFactory.getLog(JavaConfigMain.class);
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework")) {
           // context.getBean("messageSendService");
            //context.getBean("messageSendService", MessageSendService.class)
              //      .doSendMessage(new User("안길웅","lg2000f","01083873371"),"안녕하세요.");

        }
    }
}
