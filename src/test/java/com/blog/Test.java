package com.blog;

import com.alibaba.fastjson.JSON;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

import static java.security.MessageDigest.*;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        RestTemplate template =new RestTemplate();
        Map<String,Object> param = new HashMap<>();
        SendReq sendReq =new SendReq();
        sendReq.setApId("jtdl");
        sendReq.setEcName("新疆锦泰电力有限责任公司");
        sendReq.setSecretKey("Lshwyfb@02");
        sendReq.setMobiles("15895405170");
        sendReq.setContent("发送成功了吗");
        sendReq.setSign("Pp5CoH8gU");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("新疆锦泰电力有限责任公司");
        stringBuffer.append("jtdl");
        stringBuffer.append("Lshwyfb@02");
        stringBuffer.append("15895405170");
        stringBuffer.append("发送成功了吗");
        stringBuffer.append("Pp5CoH8gU");

        String selfMac = encryption(stringBuffer.toString());
        sendReq.setMac(selfMac);

        String reqText = JSON.toJSONString(sendReq);

        String encode = Base64.encodeBase64String(reqText.getBytes("UTF-8"));

        String resStr = sendPost("http://112.35.1.155:1992/sms/norsubmit",encode);


        System.out.println("发送短信结果："+resStr);

        SendRes sendRes = JSON.parseObject(resStr,SendRes.class);

        if(sendRes.isSuccess() && !"".equals(sendRes.getMsgGroup()) && "success".equals(sendRes.getRspcod())){
            System.out.println("success");
        }else{
            System.out.println("error");
        }

        //ResponseEntity<Map> responseEntity =template.postForEntity("http://112.35.1.155:1992/sms/norsubmit",selfMac,Map.class);
        //Map map = responseEntity.getBody();
    }

    private static String sendPost(String url, String param) {
        OutputStreamWriter out = null;

        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("contentType","utf-8");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(param);
            out.flush();


            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static String encryption(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

}
