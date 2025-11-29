package com.decsec.seclevel.sec;



import com.decsec.seclevel.util.StrUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DES3 {

    
    private static final String Algorithm = "DESede";
    
    private static final String PASSWORD_CRYPT_KEY = "abcdefghijklmnopqrstuvwx";

    
    public static String encryptMode(byte[] src,String sKey,String charsetEncoding){
       
            SecretKey deskey = new SecretKeySpec(sKey.getBytes(charsetEncoding), Algorithm);    
            Cipher c1 = Cipher.getInstance(Algorithm);    
            c1.init(Cipher.ENCRYPT_MODE, deskey);   
            
            return parseByte2HexStr(c1.doFinal(src));
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

   
    public static String encryptMode(byte[] src) {
        try {
            SecretKey deskey = new SecretKeySpec(PASSWORD_CRYPT_KEY.getBytes(StandardCharsets.UTF_8), Algorithm);    //生成密钥
            Cipher c1 = Cipher.getInstance(Algorithm);    
            c1.init(Cipher.ENCRYPT_MODE, deskey);   
        
            return parseByte2HexStr(c1.doFinal(src));
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

   
    public static byte[] des3Decrypt(byte[] src,String tarKey,String charsetEncoding) throws Exception{
        SecretKey deskey = new SecretKeySpec(tarKey.getBytes(charsetEncoding), "DESede");
        Cipher c1 = Cipher.getInstance("DESede");
        c1.init(Cipher.DECRYPT_MODE, deskey);    
        return c1.doFinal(src);
    }

  
    public static byte[] decryptMode(byte[] src) {
        try {
            SecretKey deskey = new SecretKeySpec(PASSWORD_CRYPT_KEY.getBytes("UTF-8"), Algorithm);
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);    
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }


  
    private static String parseByte2HexStr(byte buf[]) {
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

   
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {




  
        String secretArr=encryptMode("测试".getBytes(StandardCharsets.UTF_8));

        System.out.println(secretArr);

   
        byte[] myMsgArr = decryptMode(parseHexStr2Byte(secretArr));
        System.out.println(new String(myMsgArr));




    }


}
