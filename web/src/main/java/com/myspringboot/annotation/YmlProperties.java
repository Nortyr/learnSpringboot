package com.myspringboot.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: 陈晖
 * @Date:2019/1/10 0010
 * @Descroption:
 */

@Component
@Data
public class YmlProperties {
    @Value("${server.port}")
    private  Integer port;
    @Value("${server.port}")
    public void setPort(Integer port) {
        this.port = port;
    }
}
