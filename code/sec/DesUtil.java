package com.decsec.seclevel.sec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;

public class DesUtil {

    public static void main(String[] args) throws Exception {
        DesUtil desUtil = new DesUtil();

        String encrypt = desUtil.encrypt("测试DES加密", Charset.forName("utf8"), DESKey);

        System.out.println(encrypt);

        String decrypt = desUtil.decrypt(encrypt, Charset.forName("utf8"), DESKey);
        System.out.println(decrypt);

    }


    public static String DESKey="12345678";

   
        public String encrypt(String srcStr, Charset charset, String sKey) {

        byte[] src = srcStr.getBytes(charset);
        byte[] buf = encrypt(src, sKey);
        return parseByte2HexStr(buf);
    }



   
    public String decrypt(String hexStr, Charset charset, String sKey) throws Exception {



        byte[] src = parseHexStr2Byte(hexStr);
        byte[] buf = decrypt(src, sKey);
        return new String(buf, charset);
    }

    
    private byte[] encrypt(byte[] data, String sKey) {
        try {
            byte[] key = sKey.getBytes();
           
            IvParameterSpec iv = new IvParameterSpec(key);
            DESKeySpec desKey = new DESKeySpec(key);
           
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
          
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
           
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
         
            return cipher.doFinal(data);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


   
    private  byte[] decrypt(byte[] src, String sKey) throws Exception {
        byte[] key = sKey.getBytes();
       
        IvParameterSpec iv = new IvParameterSpec(key);
      
        DESKeySpec desKey = new DESKeySpec(key);
      
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
       
        SecretKey securekey = keyFactory.generateSecret(desKey);
     
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      
        cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
     
        return cipher.doFinal(src);
    }

  
    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

   
    private byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }




}
