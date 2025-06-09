package com.ohgiraffers.base64;

import java.util.Base64;

public class EncodingDecoding {

    public static void main(String[] args) {
        
        // java 8에서 제공하는 기본 Base64 Encoder와 Decoder
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        
        /* encode */
        String testStr = "base64로인코딩한비밀키";
        byte[] encodeArr = testStr.getBytes();
        
        byte[] encdeByte = encoder.encode(encodeArr);
        String encodeStr = new String(encdeByte);
        System.out.println("encodeStr = " + encodeStr);
        
        /* decode */
        byte[] decodeByte = decoder.decode("LH9QZL8upsPBfuDY+Dkb1kT9DZIIUSuA2u4O6Lfi3mkEfeWtETpVTcR/8SMZdJWn/xNTuCQBE6rBvDXgnVmscQ==");
        System.out.println("decodeStr = " + new String(decodeByte));
    }
}
