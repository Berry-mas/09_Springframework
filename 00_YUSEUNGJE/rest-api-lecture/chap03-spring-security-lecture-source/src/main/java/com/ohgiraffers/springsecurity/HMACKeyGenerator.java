package com.ohgiraffers.springsecurity;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HMACKeyGenerator {

    public static void main(String[] args) {
         
        /* HS512를 위한 KeyGenerator 생성 */
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");
            keyGenerator.init(512); // 512 비트 키 사이즈 설정 
            
            /* 비밀 키 생성 */
            SecretKey secretKey = keyGenerator.generateKey();
            System.out.println("secretKey.getEncoded() = " + secretKey.getEncoded());

            /* 키를 Base64로 인코딩하여 문자열로 변환 */
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("HS512 Key : " + encodedKey);
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
