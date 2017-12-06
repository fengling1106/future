package com.valen.future.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder; 
import sun.misc.BASE64Decoder;
import java.math.BigInteger;  
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;  
import javax.crypto.spec.SecretKeySpec;  
import org.apache.commons.codec.binary.Base64;    

import sun.misc.BASE64Encoder;


/**
 * @author fengling
 * @create 2017-11-23
 * @Description 加密工具类
 */

@SuppressWarnings("restriction")
public class Encrypt
 {
	//AES秘钥
    private static final String KEY = "gzcmos213gzcmos1";  
    //算法定义
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";      

    //AES加密 ,参数：原始字符串
    public static String aesEncrypt(String strSrc) throws Exception {
    	
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128);  
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);  
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
        String encString = Base64.encodeBase64String(cipher.doFinal(strSrc.getBytes("utf-8")));
         
        return encString;  
    }  
    
    //AES解密，参数：已加密字符串
    public static String aesDecrypt(String strEncrypt) throws Exception {  
       
    	//字符串字节化
    	byte[] encryptBytes = new BASE64Decoder().decodeBuffer(strEncrypt);    	
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128);  
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);  
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
        
        //已解密的字节
        byte[] decryptBytes = cipher.doFinal(encryptBytes);  
        
        return new String(decryptBytes); 
    }     
    
    
	//MD5签名
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //获取MD5固定长度
        MessageDigest md5=MessageDigest.getInstance("MD5");
        
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }     
    
    public static void main(String[] args) throws Exception {  
        String content = "15985155210";  
        System.out.println("加密前：" + content);  
  
        System.out.println("加密密钥和解密密钥：" + KEY);  
  
        String encrypt = aesEncrypt(content);  
        System.out.println("加密后：" + encrypt);  
  
        String decrypt = aesDecrypt(encrypt);  
        System.out.println("解密后：" + decrypt);  
    }      
}
