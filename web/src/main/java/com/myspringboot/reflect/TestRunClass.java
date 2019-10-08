package com.myspringboot.reflect;

/**
 * @author: 陈晖
 * @Date: Create in 下午 6:33 2019/10/8 0008
 * @Descroption:
 */


public class TestRunClass {

        private String MSG = "aaaaaaa";

        private void privateMethod(String head , int tail){
            System.out.println(head + tail);
        }

        public String getMsg(){
            return MSG;
        }

}
