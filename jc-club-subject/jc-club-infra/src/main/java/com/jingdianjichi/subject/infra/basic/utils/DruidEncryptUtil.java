package com.jingdianjichi.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 数据库加密util
 *
 * @author: ChickenWing
 * @date: 2023/10/1
 */
public class DruidEncryptUtil {

    private static String publicKey;

    private static String privateKey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey:" + privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey:" + publicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    /***
     * @param plainText
     *@Return:{@link java.lang.String}加密
     *@throws
     *@author:houhou
     *@date:2023/11/12 0012 12:34
     */
    public static String encrypt(String plainText) throws Exception {
        String encrypt = ConfigTools.encrypt(privateKey, plainText);
        System.out.println("encrypt:" + encrypt);
        return encrypt;
    }

    /**
     * @param encryptText
     *@Return:{@link java.lang.String}
     *@throws
     *@author:houhou
     *@date:2023/11/12 0012 12:34
     * 解密
     */
    public static String decrypt(String encryptText) throws Exception {
        String decrypt = ConfigTools.decrypt(publicKey, encryptText);
        System.out.println("decrypt:" + decrypt);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("123456");
        System.out.println("encrypt:" + encrypt);
    }

}
