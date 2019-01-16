package com.zf.demo4jsp.units;

public class AlipayConfig {
    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID（填自己的，下面都是改过的~）
    public static String app_id = "2019011262875331";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥（填自己的，下面都是改过的~）
    public static String private_key = "MIIEpAIBAAKCAQEAxDKZk4FjdURqpxpar9EYRp+X2YmThD40vTVN0ECj1AXoTvtE\n" +
            "pwfTgYK1h9wbIN6i4ik1tXgOWn3aWvaSuWDtXJbKXrOojq4lioNDYYa6QCoD2VM2\n" +
            "J+8qjJ8yPCuBhMxd5CD/arWr8thc77Q6r258MPVS2VHbkrfx/wwWM6+qQpitwRST\n" +
            "/pp/ZExMO3V4FfamU3IFF7yEDzAL5RyzfZ1f3Z30XBwdRIedmlyfV88qsb9pUONh\n" +
            "Flxu0wQlg8G32y2KXsCjaqWxEYiNoPAIj/M/fS1RGv28YBqcGoJpnpfMpw4QM6We\n" +
            "LjLiqpgTYElbuaxBHKpvU061mvsPUTYx7BHuGQIDAQABAoIBAG6pb7AgSd3p4hIw\n" +
            "rjf+wyeKetbLX3Y2s/6Io0Q0QXOkhVyPIzDnHCgvdn6T6oVGri7MOawKdGYcGF44\n" +
            "N5fyEM+piamSwh8AINKYqRfIKyNnz1X0Nlad8qzwWiBQFbS2pLq41ff1UnAeE4Vs\n" +
            "bbFnqwreRIWpQyTlNcy6n4c1rN30TLFESrtBGM/jSE4DmuQQaCRHkKb6tUSeo8Xy\n" +
            "Ag9A7wKjLLO1opZsL9WA3ONTfrhTAbpg76lKQmRAN+KEVwclb+KAg+0HprwrT1A2\n" +
            "TuCncEUMZWO3BGN/iNzqNSu+Q0UttrjYVAqTgykCMgI750SvkWYYCJkLVRf43Rm4\n" +
            "Qgg9BhECgYEA7snUyrp9o5EC/mfDYFOCPGwFlH2ZNO0yNFwZedX74dfb4l1UY5Io\n" +
            "jZ5ATFaEB1UPn+bRIuqI/HXt5FJPM9ABLMNd2cMKLOWL5uMKjaM04b+/aE+sKgwL\n" +
            "UB47P7PLIrZYtr07gumDR+mrRcDlRZqD6kgpGmDMap+EYHvSgdqsv10CgYEA0lbg\n" +
            "TD5i9TUQ/6SsH6u3Y3OeL5wWokAAEbgNSbMF9U9MYiiJ1lqdBBM8pIfGzIutiR9e\n" +
            "WLjNJ1fozUbGtj419tHPdY/XmnIEV5nPdqbrORR/qAM5ou6b7EPy/bEEa7Kw4FUM\n" +
            "Fk2r353r1WISzjz5DS4Y1eYlwPnwt1WATjbsie0CgYEA1zBj514woxqnjASOeVxI\n" +
            "XZMrZCnby2qGd9EX1EgWeexBZ7mbty+cBCO85g6BZOou7nbfuYuKb5kHDV9vqM2m\n" +
            "gWR+SyQNI3CppySr+gA+Q8K9B4/lIu8/sq/LzRiF035obCYUX2F4wXG+u1meRB9/\n" +
            "Cb6F7BOXo+6lKR3tEsCyNLECgYEAm91s0JLaWcI9GnM4aS+h8bxXWAhebVTnuDme\n" +
            "/yH+JE3i2EoZ+hGjkMWAhptmoWRP7/CixTQMMj9eb98mmR14d7H5/a/doMEknpWH\n" +
            "uvDuFZovDp11NFuEh4vCoGNwVy5PC616C3z7A/XOMI1ASju8ghvKo5asG1gbHH/r\n" +
            "WAozNfECgYAqAr0P5fG6fazAXlljVPEpEpQA3XWn9yG+zD5bHZprKBiztEKYpoIO\n" +
            "ugA801GhKM8dqIyvYJcFZCIulmNC14nY3Hg8EwzU9I7Ldm0pxLpSx2+cr0P/8F+N\n" +
            "uAHWbIBwXlOZtywIsQMEq8rCO2sViVCIIjD+qpvvqmFQ2kPSy43P0A==";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "http://www.linhongcun.com/SpringBootPay-0.0.1-SNAPSHOT/pay/notifyUrl";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "http://www.linhongcun.com/SpringBootPay-0.0.1-SNAPSHOT/pay/returnUrl";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxDKZk4FjdURqpxpar9EY\n" +
            "Rp+X2YmThD40vTVN0ECj1AXoTvtEpwfTgYK1h9wbIN6i4ik1tXgOWn3aWvaSuWDt\n" +
            "XJbKXrOojq4lioNDYYa6QCoD2VM2J+8qjJ8yPCuBhMxd5CD/arWr8thc77Q6r258\n" +
            "MPVS2VHbkrfx/wwWM6+qQpitwRST/pp/ZExMO3V4FfamU3IFF7yEDzAL5RyzfZ1f\n" +
            "3Z30XBwdRIedmlyfV88qsb9pUONhFlxu0wQlg8G32y2KXsCjaqWxEYiNoPAIj/M/\n" +
            "fS1RGv28YBqcGoJpnpfMpw4QM6WeLjLiqpgTYElbuaxBHKpvU061mvsPUTYx7BHu\n" +
            "GQIDAQAB";

    public static String signtype = "RSA2";

}
