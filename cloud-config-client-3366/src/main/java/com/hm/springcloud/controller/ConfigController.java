package com.hm.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    /**
     * 需要运维人员发送Post请求刷新3355
     * curl  -X POST "http://localhost:3355/actuator/refresh"
     */

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")  //yml中config
    private String configInfo;

    @RequestMapping("/configInfo")
    public String getServerPort() {

        return "serverPort: "+serverPort+"\t\n\n configInfo: "+configInfo;
    }
}
