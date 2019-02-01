package com.zf.demo4jsp;



import org.springframework.util.ResourceUtils;

import java.io.File;

public class wxTest {

    public static void main(String[] args) throws Exception{
        File file = ResourceUtils.getFile("classpath:config/apiclient_cert.p12");
        if(file.exists()){
            File[] files = file.listFiles();
            if(files != null){
                for(File childFile:files){
                    System.out.println(childFile.getName());
                }
            }
        }
    }


}
