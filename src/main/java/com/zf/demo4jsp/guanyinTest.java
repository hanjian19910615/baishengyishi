package com.zf.demo4jsp;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class guanyinTest {


    public static void main(String args[]) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        //String decodeName="7-1-4";
        String fours="10";//个
        String deca ="25";//十
        String hundred="15";//百
        int fours1=Integer.parseInt(fours);
        int deca1=Integer.parseInt(deca);
        int hundred1=Integer.parseInt(hundred);
        int num=hundred1%8;//百位
        int num1=deca1%8;//十位
        int num2= fours1%6;//个位
        System.err.println("格式:"+num2+"-"+num1+"-"+num);
        String num3 = String.valueOf(num);//百位
        String num4 = String.valueOf(num1);//百位
        String num5 = String.valueOf(num2);//百位
        String decodeName=num3+"-"+num4+"-"+num5;//签数
        System.err.println("签数:"+decodeName);

        if(decodeName=="1-1-1"){
            System.err.println("进来了1");
        }else if(decodeName.equals("7-1-4")){
            System.err.println("进来了2");
        }

        //return mv;



    }

}
