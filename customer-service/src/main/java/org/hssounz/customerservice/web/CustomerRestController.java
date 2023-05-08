package org.hssounz.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController @RefreshScope
public class CustomerRestController {

    @Value("${global.params.p1}")
    private String p1;
    @Value("${spring.cloud.discovery.enabled}")
    private String x;

    @GetMapping("/params")
    public Map<String, String> params(){
        return Map.of("p1", p1, "x", x);
    }
}
