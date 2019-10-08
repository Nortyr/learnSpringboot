package com.myspringboot.transaction.po;

import lombok.Data;

import javax.persistence.Id;

/**
 * @Auther: 陈晖
 * @Date:2019/1/15 0015
 * @Descroption:
 */

@Data
public class Person {
    @Id
    private String id;
    private String name;
}
