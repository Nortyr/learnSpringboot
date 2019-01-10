package com.myspringboot.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: 陈晖
 * @Date:2019/1/10 0010
 * @Descroption:
 */

@Component
@Data
@ConfigurationProperties("server")
public class YmlProperties1 {

    private  String port;

}
