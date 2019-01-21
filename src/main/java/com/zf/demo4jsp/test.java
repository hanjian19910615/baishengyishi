package com.zf.demo4jsp;

public class test {

    public static void main(String[] args) {
        String date="1991-01-21";
        int num1=Integer.parseInt(date.substring(0,1)) ;//1
        int num2= Integer.parseInt(date.substring(1,2));//9
        int num3= Integer.parseInt(date.substring(2,3));//9
        int num4= Integer.parseInt(date.substring(3,4));//1
        int num5= Integer.parseInt(date.substring(5,6));//0
        int num6= Integer.parseInt(date.substring(6,7));//6
        int num7= Integer.parseInt(date.substring(8,9));//1
        int num8= Integer.parseInt(date.substring(9,10));//5
        System.out.println("====="+num1+num2+num3+num4+num5+num6+num7+num8);
        int number1=num1+num2;
        int number2=number1+num3;
        int number3=number2+num4;
        int number4=number3+num5;
        int number5=number4+num6;
        int number6=number5+num7;
        int number7=number6+num8;
        String strNum=String.valueOf(number7);
        System.out.println("AAAAAAA===="+number7);
        int newNunber1=Integer.parseInt(strNum.substring(0,1));
        int newNunber2=Integer.parseInt(strNum.substring(1,2));
        int newNunber3 = newNunber1+newNunber2;

//        if(){
//
//        }
        System.out.println("CCCCCC====="+newNunber3);


    }
    }
