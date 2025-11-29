package com.decsec.seclevel.sec;



import com.decsec.seclevel.util.ChaCha20;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class AdaptiveEncryptionAlgorithm {

    public static void main(String[] args) throws Exception {

        String test="Hello World";

        AdaptiveEncryptionAlgorithm adaptiveEncryptionAlgorithm=new AdaptiveEncryptionAlgorithm();

        Map<String, Object> map = adaptiveEncryptionAlgorithm.adaptiveEncryption(test, null, 0, 7, 10, 0);

        System.out.println(map.get("tarStr"));
        System.out.println(map.get("key"));
        System.out.println(map.get("keyO"));

        String s = adaptiveEncryptionAlgorithm.adaptiveDecryption("", null, (String) map.get("keyO"), (byte[]) map.get("tarStr"));

        System.out.println(s);


    }

   
    public Map<String,Object> adaptiveEncryption(String srcStr, String charsetEncoding,double n,int encryptionType,int deepN,double keyN) throws Exception {


        
        if(encryptionType==0 || encryptionType<0){
            encryptionType=3;
        }
      
        if(charsetEncoding==null || charsetEncoding.equals("")){
            charsetEncoding="UTF8";
        }
       
        if(deepN==0){
            deepN=1;
        }
      
        int deep=0;
        switch (encryptionType){
            case 1: deep=8*deepN;
            break;
            case 2: deep=24*deepN;
            break;
            case 3: deep=16*deepN;
            break;
            case 7: deep=32*deepN;
            break;

        }


      
        int length = srcStr.length();
       
        String randomStr= UUID.randomUUID().toString().replaceAll("-","").substring(0,(int)(32*Math.random()+1));

        


        if(n==0.0){
            n=Math.random();
        }


      
        int position = (int)Math.pow(length, n);
      
        StringBuffer sb=new StringBuffer(srcStr);

        
        String tarStr=sb.insert(position,randomStr).toString();

        
       

     
        String keyO="";

      
        if(keyN==0.0){
            keyN=n;
            keyO=randomStr.length()+"FF"+length+"FF"+n+"FF"+encryptionType+"FF"+deepN+"FF";

        }
        else{
            keyO=randomStr.length()+"FF"+length+"FF"+n+"FF"+encryptionType+"FF"+deepN+"FF"+keyN+"FF";
        }
       
        int keyOLength = keyO.length();


      
        String keySub="";
       
        if(keyOLength>deep){
          
            keySub=tarKey.substring(positionKeyN, positionKeyN+deep);
           

         
        }
        else{
           
            keySub=keyO;
            int count=(deep-keyOLength)/UUID.randomUUID().toString().length();
            for (int i = 0; i < count; i++) {
                String str=UUID.randomUUID().toString();
                keySub+=str;
            }
            int keySubLength=keySub.length();

          
            if(deep % keySubLength !=0){
                String str=UUID.randomUUID().toString().substring(0,deep % keySubLength);

                keySub+=str;
            }
          
            keyO=keySub;
        }

       

        Map<String,Object> resultMap;
       
        switch (encryptionType){
          
            case 1:

                resultMap=desEncrypt(tarStr, charsetEncoding, keySub);
                resultMap.put("keyO",keyO);
                return resultMap;

         
            case 2:
                resultMap=des3Encrypt(tarStr, charsetEncoding, keySub);
                resultMap.put("keyO",keyO);
                return resultMap;
              
            case 3:
                resultMap=aesEncrypt(tarStr, charsetEncoding, keySub);
                resultMap.put("keyO",keyO);
                return resultMap;
            case 7:
                resultMap=chacha20Encrypt(tarStr, charsetEncoding, keySub);
                resultMap.put("keyO",keyO);
                return resultMap;

        }





        return null;
    }

   
    public String adaptiveDecryption(String ciphertext,String charsetEncoding,String skey,byte[] cipher) throws Exception {
       
        String[] skeys = skey.split("FF");

        int randomStrLength=Integer.valueOf(skeys[0]);
      
        int srcStrLength=Integer.valueOf(skeys[1]);
     
        double n=Double.valueOf(skeys[2]);
      
        int encryptionType=Integer.valueOf(skeys[3]);
      
        int deepN=Integer.valueOf(skeys[4]);
      
        int keyN=0;
        if(skeys.length==7){

            keyN=Integer.valueOf(skeys[5]);
        }
       
        if(charsetEncoding==null || charsetEncoding.equals("")){
            charsetEncoding="UTF-8";
        }

        
        int deep=0;

        switch (encryptionType){
            case 1:
                deep=8*deepN;
                break;
            case 2:
                deep=24*deepN;
                break;
            case 3:
                deep=16*deepN;
                break;
            case 7:
                deep=32*deepN;
                break;
        }
      
        String tarKey="";
        if(skey.length()>deep){
           
            tarKey=skey.substring(0, deep);
        }
        else if(skey.length()==deep){
            tarKey=skey;
        }
     
        String srcStrSec=null;
        switch (encryptionType){
            case 1: srcStrSec = decrypt(ciphertext, Charset.forName(charsetEncoding), tarKey);
            break;
            case 2: srcStrSec = des3Decrypt(ciphertext, charsetEncoding, tarKey);
            break;
            case 3: srcStrSec = aesDecrypt(ciphertext, charsetEncoding, tarKey);
            break;
            case 7: srcStrSec=chacha20Decrypt(cipher, charsetEncoding, tarKey);
            break;
        }

     
        int position = (int)Math.pow(srcStrLength, n);
        StringBuffer sb=new StringBuffer(srcStrSec);
      
        String srcStr=sb.delete(position,position+randomStrLength).toString();


        return srcStr;
    }




    
    private Map<String,Object> desEncrypt(String srcStr, String charsetEncoding,String sKey) throws Exception {
       
        Map<String,Object> resultMap=new HashMap<String,Object>();
        String tarStr=srcStr;
       
        for(int i=0;i<sKey.length()/8;i++){

            byte[] src = tarStr.getBytes(charsetEncoding);
            byte[] buf = desEncrypt(src, sKey.substring(i*8,(i+1)*8));
            tarStr=parseByte2HexStr(buf);

        }

        resultMap.put("tarStr",tarStr);

        resultMap.put("key",sKey);

        return  resultMap;
    }

   
    private Map<String,Object> des3Encrypt(String srcStr, String charsetEncoding,String sKey) throws Exception {

       
        Map<String,Object> resultMap=new HashMap<String,Object>();
        String tarStr=srcStr;
       
        for(int i=0;i<sKey.length()/24;i++){

            byte[] src = tarStr.getBytes(charsetEncoding);

            tarStr = DES3.encryptMode(src, sKey.substring(i*24,(i+1)*24), charsetEncoding);


        }

        resultMap.put("tarStr",tarStr);

        resultMap.put("key",sKey);


        return resultMap;
    }

    private Map<String,Object> chacha20Encrypt(String srcStr, String charsetEncoding,String sKey) throws Exception {

        Map<String,Object> resultMap=new HashMap<String,Object>();
        byte[] tarStr=srcStr.getBytes(StandardCharsets.UTF_8);
        for(int i=0;i<sKey.length()/32;i++){

            byte[] src = tarStr;
            tarStr=ChaCha20.chacha20(true, sKey.substring(i*32,(i+1)*32).getBytes(StandardCharsets.UTF_8),ChaCha20.generateNonce(),src);


        }

        resultMap.put("tarStr",tarStr);
        resultMap.put("key",sKey);

        return resultMap;
    }

    
    
   private Map<String,Object> aesEncrypt(String srcStr, String charsetEncoding,String sKey) throws Exception {
    
       Map<String,Object> resultMap=new HashMap<String,Object>();
       String tarStr=srcStr;

     
       for(int i=0;i<sKey.length()/16;i++){

           byte[] src = tarStr.getBytes(charsetEncoding);

           tarStr = AESUtil.encrypt(src,sKey.substring(i*16,(i+1)*16));


       }

       resultMap.put("tarStr",tarStr);

       resultMap.put("key",sKey);

       return resultMap;

   }


   
    private byte[] desEncrypt(byte[] data, String sKey) {
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

    private String chacha20Decrypt(byte[] hexStr, String charset, String tarKey) throws Exception{
        byte[] srcStr = hexStr;

        for (int i = tarKey.length() / 32; i > 0; i--) {
            srcStr=ChaCha20.chacha20(false, tarKey.substring((i - 1) * 32, i * 32).getBytes(charset), ChaCha20.generateNonce(),srcStr);
        }

        return new String(srcStr, StandardCharsets.UTF_8);
    }

   
    private String aesDecrypt(String hexStr, String charset, String tarKey) throws Exception {
        String srcStr = hexStr;

        for (int i = tarKey.length() / 16; i > 0; i--) {

            byte[] buf = AESUtil.aesDecrypt(srcStr, tarKey.substring((i - 1) * 16, i * 16),charset);
            srcStr = new String(buf, charset);

        }
        return srcStr;
    }

    
    private String des3Decrypt(String hexStr, String charset, String tarKey) throws Exception {

        String srcStr = hexStr;

        for (int i = tarKey.length() / 24; i > 0; i--) {

            byte[] src = parseHexStr2Byte(srcStr);
            byte[] buf = DES3.des3Decrypt(src, tarKey.substring((i - 1) * 24, i * 24),charset);
            srcStr = new String(buf, charset);

        }
        return srcStr;
    }

    
    private String decrypt(String hexStr, Charset charset, String tarKey) throws Exception {

        String srcStr = hexStr;

        for (int i = tarKey.length() / 8; i > 0; i--) {

            byte[] src = parseHexStr2Byte(srcStr);
            byte[] buf = decrypt(src, tarKey.substring((i - 1) * 8, i * 8));
            srcStr = new String(buf, charset);

        }
        return srcStr;
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


}
