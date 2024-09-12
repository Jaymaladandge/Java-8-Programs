package com.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Test2 {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		
		String inputValues = "BAJAJ|80468062|200000|FDC100001551446|DEEPIKA P KARANJI|FD|website|FD020|17501460002034|HDFC0001750|https://www.bajajfinserv.in/fixed-deposit-application-form/paymentResponse"+ "|T8weTFOVfrlb";
		
		final String ALGORITHM = "Hmacsha256";
		String checksumRequest=inputValues;
		
		String key="T8weTFOVfrlb";
		
		Mac sha256_HMAC = Mac.getInstance(ALGORITHM);

        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), ALGORITHM);
        sha256_HMAC.init(secret_key);
        
        String checksum=byteArrayToHex(sha256_HMAC.doFinal(checksumRequest.getBytes("UTF-8")));
        System.out.println("===== Generated checksum in calculateChecksum ==== " + checksum);
		
	}
	
	public static  String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
