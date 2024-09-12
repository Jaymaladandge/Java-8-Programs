package com.encryptDecrypt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.opencsv.CSVWriter;

public class Test {

	private final int keySize;
	private final int iterationCount;
	private Cipher cipher;
	SecretKey key;
	byte[] encrypted;
	static String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
	private static SecureRandom secrd = new SecureRandom();
	
	
	
	public Test(int keySize, int iterationCount)throws IOException {
		this.keySize = keySize;
		this.iterationCount = iterationCount;
		try { 
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (Exception e)
		{
			System.out.println("------Exception in AesUtil Constructor------"+ e);
		}
	}

	public static String getSalt(int length) throws IOException  
	{
		StringBuilder returnValue = new StringBuilder(length);
		String alphabet = "0123456789ABCDEFabcdef";
		/*for (int i = 0; i < length; i++) {
			returnValue.append(alphabet.charAt(secrd.nextInt(alphabet.length())));
		}*/
		return alphabet;
	}
	
	private SecretKey generateKey(String salt, char[] passphrase)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			KeySpec spec = new PBEKeySpec(passphrase, Hex.decodeHex(salt.toCharArray()), iterationCount, keySize);
			key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		} catch (Exception e) {
			System.out.println("------Exception in generateKey Method------"+ e);
		}
		return key;
	}
	
	public  String encrypt(String data) {
		
		
		try {
			
			SecretKey key = generateKey(Test.getSalt(20), "abcdef".toCharArray());
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(Hex.decodeHex(iv.toCharArray())));
			encrypted = cipher.doFinal(data.getBytes("UTF-8"));
			
			
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Base64.encodeBase64String(encrypted);
	}
	
	public static void main(String[] args) {
		
		//---------------------------Single URL testing--------------------------------
		int keySizeVal = 128;
		int iterationCountResponse = 1000;
		String sub = null;
		
		//String url = "https://152.67.17.233/fixed-deposit-application-form?PartnerCode=172107&utm_source=Emerging%20FD&utm_medium=B2B&utm_campaign=Emerging%20FD";
		//String url = "https://152.67.17.233/fixed-deposit-application-form?PartnerCode=172107&PartnerName=aaa bbb&utm_source=Emerging%20FD&utm_medium=B2B&utm_campaign=Emerging%20FD";
		
		String url = "https://www.bajajfinserv.in/fixed-deposit-application-form?PartnerCode=I12675&utm_source=ACMS&utm_medium=B2B&utm_campaign=ACMS";
		sub = url.substring(url.indexOf("?")+1, url.indexOf("&"));
		System.out.println(sub.split("=")[1]);
		
		try {
			Test ancryption =new Test(keySizeVal, iterationCountResponse);
			String encryptedString = ancryption.encrypt(sub.split("=")[1]);
			
			System.out.println("encryptedString : "+encryptedString);
			
			url = url.replace(sub.split("=")[1], encryptedString);
			System.out.println("URL : "+url);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("=========================================");
		
		/*Scanner sc;
		HashMap<String,String> encryptedURLs = new HashMap<>();
		
		try {
			sc = new Scanner(new File("D:\\WorkRecords\\2023\\JAN\\9\\urls.txt"));
			sc.useDelimiter(",");
		    while (sc.hasNext()) {
		    	String s = sc.next();
		    	System.out.print(s);
		    	sub=s.substring(s.indexOf("?")+1, s.indexOf("&"));
		    	System.out.println("\n==="+sub);
		    	
		    	System.out.println(sub.split("=")[1]);
				
				try {
					Test ancryption =new Test(keySizeVal, iterationCountResponse);
					String encryptedString = ancryption.encrypt(sub.split("=")[1]);
					
					System.out.println("encryptedString : "+encryptedString);
					encryptedString = URLEncoder.encode(encryptedString, StandardCharsets.UTF_8.toString());
					System.out.println("encryptedString : "+encryptedString);
					
					s=s.replace(sub.split("=")[1], encryptedString);
					
					encryptedURLs.put(sub.split("=")[1], s);
					
					System.out.println("New URL : " +s);	
					
					System.out.println("---------------------------------------------");
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		    sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 String csv = "D:\\WorkRecords\\2023\\JAN\\9\\EncryptedURLs.csv";
		 BufferedWriter bw=null;
		 try {
			bw = new BufferedWriter(new FileWriter(csv));
			
			for(Map.Entry<String, String> entry : encryptedURLs.entrySet()) {
				bw.write(entry.getKey());
				bw.write(",");
				bw.write(entry.getValue());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		    
	}
	
}
