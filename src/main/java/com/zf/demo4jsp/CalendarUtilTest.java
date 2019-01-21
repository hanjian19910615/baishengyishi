package com.zf.demo4jsp;

import com.zf.demo4jsp.entity.CalendarUtil;

public class CalendarUtilTest {



    public static void main(String[] args)throws Exception{
        System.out.println("******农历转公历******");
        System.out.println(CalendarUtil.lunarToSolar("19910615", false));
       // System.out.println(CalendarUtil.lunarToSolar("19920702", false));
    }




}
