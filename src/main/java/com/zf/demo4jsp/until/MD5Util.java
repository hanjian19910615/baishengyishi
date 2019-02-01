package com.zf.demo4jsp.until;


import com.github.wxpay.sdk.WXPayConstants;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
public class MD5Util {
    public static String getSign(Map<String, String> data) throws Exception {
        WXMyConfigUtil config = new WXMyConfigUtil();
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(WXPayConstants.FIELD_SIGN)) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(config.getKey());
        /*MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] array = new byte[0];
        try {
            array = md.digest(sb.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte item : array) {
            sb2.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb2.toString().toUpperCase();*/
        String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;
    }
    public static String createSign(String characterEncoding, SortedMap<Object, Object> packageParams) throws Exception {
        WXMyConfigUtil config = new WXMyConfigUtil();
        StringBuffer sb = new StringBuffer();
        Set<?> es = packageParams.entrySet();
        Iterator<?> it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
//            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k) && !"notify_url".equals(k)&& !"out_trade_no".equals(k)&& !"spbill_create_ip".equals(k)&& !"total_fee".equals(k)&& !"trade_type".equals(k)) {
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k) ) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + config.getKey());
//        String stringA="appid=wxc7b425229b570867&mch_id=1406330002&nonce_str=1702585759&key=ab42e0b7aa6bce35164a2d14855d7264";
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
//        String sign = MD5Util.MD5Encode(stringA, characterEncoding).toUpperCase();
//        System.out.println(sign);
//        System.out.println(MD5Util.MD5Encode("appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA&key=192006250b4c09247ec02edce69f6a2d", characterEncoding).toUpperCase());
//        System.out.println(sign);
        return sign;
    }
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
