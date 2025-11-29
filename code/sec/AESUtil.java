package com.decsec.seclevel.sec;


import com.decsec.seclevel.util.StrUtil;
import org.apache.commons.codec.binary.Base64;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


    public class AESUtil {

        private static final String KEY_ALGORITHM = "AES";
        private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
        private static final String PASSWORD="12345678";

     
        public static String encrypt(byte[] src,String sKey){
            try {
                Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

                cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(sKey));

                byte[] result = cipher.doFinal(src);

                return Base64.encodeBase64String(result);
            } catch (Exception ex) {
                Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }

       
        public static String encrypt(String content){
                return encrypt(content,PASSWORD);
        }

      
        public static String encrypt(String content, String password) {
            try {
                Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

                byte[] byteContent = content.getBytes("utf-8");

                cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));

                byte[] result = cipher.doFinal(byteContent);

                return Base64.encodeBase64String(result);
            } catch (Exception ex) {
                Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }

       
        public static byte[] aesDecrypt(String src,String tarKey,String charset) throws Exception{
           
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

           
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(tarKey));
 
            return cipher.doFinal(Base64.decodeBase64(src));


        }

    
    public static String decrypt(String content){
            return decrypt(content,PASSWORD);
        }

      
        public static String decrypt(String content, String password) {

            try {
              
                Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

                
                cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

       
                byte[] result = cipher.doFinal(Base64.decodeBase64(content));

                return new String(result, "utf-8");
            } catch (Exception ex) {
                Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }

       
        private static SecretKeySpec getSecretKey(final String password) {
           
            KeyGenerator kg = null;

            try {

                SecureRandom random=SecureRandom.getInstance("SHA1PRNG");

                random.setSeed(password.getBytes());

                kg = KeyGenerator.getInstance(KEY_ALGORITHM);

               
                kg.init(128, random);

               
                SecretKey secretKey = kg.generateKey();

                return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }

        public static void main(String[] args) {

            String s1 = AESUtil.encrypt("测试");

            System.out.println(s1);


            String decrypt = AESUtil.decrypt(s1);
            System.out.println(decrypt);


        }

    }



