package com.zf.demo4jsp.until;

import com.github.wxpay.sdk.WXPayConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
@Mapper
public class WXMyConfigUtil implements WXPayConfig {
    private byte[] certData;

    public WXMyConfigUtil() throws Exception {
       // File file = (ResourceUtils.getFile("classpath:config/apiclient_cert.p12"));
        File file = ResourceUtils.getFile("classpath:config/apiclient_cert.p12");
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    @Override
    public String getAppID() {
        return "wx2be4141e9244c9fd";
    }

    //parnerid
    @Override
    public String getMchID() {
        return "1523667471";
    }

    @Override
    public String getKey() {
        return "015bb0ff1c8b1a0a61540438f7cb07e7";
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

}
