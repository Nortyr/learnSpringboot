package com.myspringboot.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 陈晖
 * @Date: Create in 下午 3:58 2019/10/8 0008
 * @Descroption:
 */


public class test {
    public static void main(String[] args) {
        /* 给你先看一些 日常用的比较多的 快速写代码的方法*/
        System.out.println("helloWorld");
        /*接下来展示更快捷的做法*/
        System.out.println("helloworld");
        /*然后再比如集合的迭代*/
        List<String> list = new ArrayList<>();

        for (String s : list) {

        }

        for (int i = list.size() - 1; i >= 0; i--) {

        }
        for (int i = 0; i < list.size(); i++) {

        }

        String s = new String();

        /* 还有一些快捷键 迅速创建一个java类 当然 创建完之后我们还能迅速回来 */
        /* 不知道为什么快捷键 用不起来 ctrl+shift+ 1 - 9 可以让你在该处留下标记 然后无论你代码切换到了那里 按ctrl 1 - 9 都能立刻返回回来@*/
        /* alt 1 - 9 能够让人快速打开 和关闭 不想要的区域 比如*/
        /* 下面看看 code Template和live Template */
        /* 先看 code Template 能够迅速生成 我们想要的代码模板 比如要想生成一个 带增删的mapper*/
        /* 有点问题 暂时先不管它了，根据这个配置自己想要的模板即可快速生成模板 这个功能还可以有一系列的参数 仔细进入刚才那个页面就可以看到*/
        /* LiveTemplate功能更强大，不过不是用于生成一大段代码的 可以让我们输入几个字母就出来一大段代码 */

        String halloword = new String("halloword");
        String test = new String("test");
        String onhn = new String("onhn");
        /* 当然 前端用起来更是飞起*/
    }
}
