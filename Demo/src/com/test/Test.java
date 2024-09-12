package com.test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class Test {

	public static void main(String[] args) {

		String inputValues = "BAJAJ|80468062|200000|FDC100001551446|DEEPIKA P KARANJI|FD|website|FD020|17501460002034|HDFC0001750|https://www.bajajfinserv.in/fixed-deposit-application-form/paymentResponse"+ "|T8weTFOVfrlb";
		/*new */
		Digest digest = new SHA256Digest();

		HMac hMac = new HMac(digest);
		hMac.init(new KeyParameter("T8weTFOVfrlb".getBytes()));
        /*new*/
		byte[] hmacIn = inputValues.getBytes();
		hMac.update(hmacIn, 0, hmacIn.length);
		byte[] hmacOut = new byte[hMac.getMacSize()];

		hMac.doFinal(hmacOut, 0);
		String checksum = bytesToHex(hmacOut);
		
		System.out.println("===="+checksum);
		
	}

	 public static String bytesToHex(byte[] bytes) {
	        StringBuilder sb = new StringBuilder();
	        for (byte hashByte : bytes) {
	            int intVal = 0xff & hashByte;
	            if (intVal < 0x10) {
	                sb.append('0');
	            }
	            sb.append(Integer.toHexString(intVal));
	        }
	        return sb.toString();
	    }

}




