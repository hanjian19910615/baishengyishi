package com.zf.demo4jsp;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Scanner;

public class xingzuoTest {

    public static void main(String args[]) {
        //Scanner sc=new Scanner(System.in);
        //提示按照样例输入
       // System.out.println("请输入您的生日。eg:1-23");
        //输入生日
        String birthday="01-21";
        //用.切割，把月和日拿出来
        int month=Integer.parseInt(birthday.split("-")[0]);
        int day=Integer.parseInt(birthday.split("-")[1]);
        switch (month) {
            //判断是几月
            case 1:
                //判断是当前月的哪一段时间；然后就可以得到星座了；下面代码都一样的
                if(day>0&&day<20){
                    System.out.println("魔蝎座");
                }else if(day<32) System.out.println("水瓶座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 2:
                if(day>0&&day<19){
                    System.out.println("水瓶座");
                }else if(day<29) System.out.println("双鱼座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 3:
                if(day>0&&day<21){
                    System.out.println("双鱼座");
                }else if(day<32) System.out.println("白羊座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 4:
                if(day>0&&day<20){
                    System.out.println("白羊座");
                }else if(day<31) System.out.println("金牛座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 5:
                if(day>0&&day<21){
                    System.out.println("金牛座");
                }else if(day<32) System.out.println("双子座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 6:
                if(day>0&&day<22){
                    System.out.println("双子座");
                }else if(day<31) System.out.println("巨蟹座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 7:
                if(day>0&&day<23){
                    System.out.println("巨蟹座");
                }else if(day<32) System.out.println("狮子座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 8:
                if(day>0&&day<23){
                    System.out.println("狮子座");
                }else if(day<32) System.out.println("处女座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 9:
                if(day>0&&day<23){
                    System.out.println("处女座");
                }else if(day<31) System.out.println("天平座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 10:
                if(day>0&&day<24){
                    System.out.println("天平座");
                }else if(day<32) System.out.println("天蝎座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 11:
                if(day>0&&day<23){
                    System.out.println("天蝎座");
                }else if(day<31) System.out.println("射手座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            case 12:
                if(day>0&&day<22){
                    System.out.println("射手座");
                }else if(day<32) System.out.println("魔蝎座");
                else System.out.println("这个月有几天都不知道吗");
                break;
            default:
                System.out.println("木有这个月吧");
                break;
        }

    }


}
