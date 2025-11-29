package com.decsec.seclevel.util;
import org.bouncycastle.crypto.engines.ChaChaEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;



public class ChaCha20 {




    public static byte[] generateKey() {
        byte[] key = new byte[32];
        new SecureRandom().nextBytes(key);
        return key;
    }

   
    public static byte[] generateNonce() {
        byte[] nonce = new byte[8];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

  

    public static byte[] chacha20(boolean forEncryption,
                                  byte[] key,byte[] nonce, byte[] input) {

        ChaChaEngine engine = new ChaChaEngine(20);  // ChaCha20
        ParametersWithIV params = new ParametersWithIV(new KeyParameter(key), nonce);

        engine.init(forEncryption, params);

        byte[] out = new byte[input.length];
        engine.processBytes(input, 0, input.length, out, 0);




        return out;
    }

    

    private static   String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

}
