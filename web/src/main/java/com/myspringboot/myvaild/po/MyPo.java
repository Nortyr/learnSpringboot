package com.myspringboot.myvaild.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: 陈晖
 * @Date:2019/1/22 0022
 * @Descroption:
 */

@Data
public class MyPo {
    @NotNull
    private Long id;
    @Future(message="我需要一个将来的日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


}
