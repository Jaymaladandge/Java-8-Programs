package com.apiConsume;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConsumeAPI {

	String getToken() {
		String authToken="";
		try (CloseableHttpClient httpclient = HttpClients.createDefault()){
			String res="";
			String grantType = "client_credentials";
			String clientId = "10274649-8910-417b-9a52-ed05c5350c08";
			String clientSecret = "IUCwiajxWv30KiqdZVxHBVpt2ZJoIKdV5pwiJs8aHLk=";
			String authorizationURL = "https://login.microsoftonline.com/bajajfinance.in/oauth2/token";     
			String resource = "https://management.azure.com/";
			String username = "gyanendra.bhadoria@bajajfinserv.in";
			String requestParaFirst = "Bajaj@123";
			StringBuilder tokenAPIRequest = new StringBuilder(); 
			tokenAPIRequest.append("grant_type=");
			tokenAPIRequest.append(grantType);
			tokenAPIRequest.append("&client_id=");
			tokenAPIRequest.append(clientId);
			tokenAPIRequest.append("&client_secret=");
			tokenAPIRequest.append(clientSecret);
			tokenAPIRequest.append("&resource=");
			tokenAPIRequest.append(resource);
			tokenAPIRequest.append("&username");
			tokenAPIRequest.append(username);
			tokenAPIRequest.append("&password");
			tokenAPIRequest.append(requestParaFirst);

			System.out.println("jsonReq== "+tokenAPIRequest.toString() +" authorizationURL== "+authorizationURL);

			URIBuilder builder = new URIBuilder(authorizationURL);
			URI uri = builder.build();
			HttpPost req = new HttpPost(uri);
			req.setHeader("Content-Type", "application/x-www-form-urlencoded");
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(15000)
					.setConnectTimeout(15000)
					.setConnectionRequestTimeout(15000)
					.build();
			req.setConfig(requestConfig);
			StringEntity reqEntity = new StringEntity(tokenAPIRequest.toString());
			req.setEntity(reqEntity);

			try(CloseableHttpResponse response = httpclient.execute(req)){
				String statusCode = String.valueOf(response.getStatusLine().getStatusCode());
				org.apache.http.HttpEntity entity = response.getEntity();
				if (entity != null) {
					res = EntityUtils.toString(entity);
					
					System.out.println("=====dedupe token API Response=====" + res);
					JSONObject tokenAPIResponse = new JSONObject(res); 
					if(tokenAPIResponse.has("access_token")){
						authToken = tokenAPIResponse.getString("access_token");
						System.out.println("==access token=== " + authToken);
					}else if(tokenAPIResponse.has("error")){
						authToken = tokenAPIResponse.getString("error");
						System.out.println("access token has errors " + authToken);
					}else{
						System.out.println("access_token has errors ELSE " + authToken);
					}
					
				}else{
				}
			}

			return authToken;
		}catch (Exception ex){
			System.out.println("================= APIUtil : Error============== "+ex);
			return authToken;
		}
	}
	
	String getOTP() {
		
		int statusCode=0;
		String res="";
		
		StringBuilder otpReq = new StringBuilder();
		otpReq.append("{\"MOBILE\": \"");
		otpReq.append("9594154348");
		otpReq.append( "\",\"EVENT_NAME\": \"");
		otpReq.append("FD_OTP");
		otpReq.append( "\",\"SOURCE\": \"");
		otpReq.append("WEBSITE\"}");
		
		try (CloseableHttpClient httpclient = HttpClients.createDefault()){

			/**** Property File Reading *****/
			String otpendPoint = "https://bflapimprod.bajajfinserv.in/Website/Card/api/Customer/Generate_OTP";
			String accessToken =getToken();
			System.out.println("  Token in Validate OTP "+accessToken);
			System.out.println(" ========== accessToken==== :" + accessToken);
			if( ! "NA".equals(accessToken)){
				URIBuilder builder = new URIBuilder(otpendPoint);
				URI uri = builder.build();
				HttpPost req = new HttpPost(uri);
				RequestConfig requestConfig = RequestConfig.custom()
						.setSocketTimeout(15000)
						.setConnectTimeout(15000)
						.setConnectionRequestTimeout(15000)
						.build();
				req.setConfig(requestConfig);

				req.setHeader("Content-Type", "application/json");
				req.setHeader("Ocp-Apim-Subscription-Key", "ba171cadb3904c5686ea8d63a828d352");
				req.setHeader("Authorization", "Bearer " + accessToken);
				System.out.println("  Send OTP API Request :  \t "+otpReq);
				StringEntity reqEntity = new StringEntity(otpReq.toString());
				req.setEntity(reqEntity);
				
				try(CloseableHttpResponse response1 = httpclient.execute(req)){
					statusCode = response1.getStatusLine().getStatusCode();
					System.out.println("  API Status Code \t " +statusCode);
					HttpEntity entity = response1.getEntity();
					res = EntityUtils.toString(entity);
					System.out.println("  Send OTP API Response : \t "+res);
					if (statusCode == 200 && entity != null) {


						if(res.contains("success"))
						{
							JSONObject responseJson = new JSONObject(res);

							String errorCode =responseJson.has("status")?responseJson.getString("status"):"91";
							String requestID = responseJson.has("data")?((JSONObject)((JSONArray)responseJson.get("data")).get(0)).getString("request_id"):"WEBSITE";

							if("success".equals(errorCode))
							{
								res="ERROR_CODE_00";
								JSONObject request=new JSONObject(otpReq);
								responseJson=new JSONObject(res);
								responseJson.put("mobile_No__c", request.getString("MOBILE"));
								responseJson.put("requestID", requestID);

								res=responseJson.toString();
								
							}else
							{
								
								res="ERROR_CODE_91";
							}

						}
						
					}
					else if(statusCode==400)
					{
						/**** BAD Request ****/
						System.out.println("ERROR_CODE_92");

					}else if (statusCode == 500) {
						System.out.println("ERROR_CODE_99");
					}
					else{
						/*** Internal Server Error ****/
						
						System.out.println("ERROR_CODE_99");
					}
				}
				
			}
			else{
				System.out.println("ERROR_CODE_99");
			}
		}
		catch (Exception ex){
			System.out.println("============= SEND OTP : ERROR=========== \n"+ex);
			System.out.println("  Send OTP API Response : \t "+res);
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		
		
	/*	ConsumeAPI api=new ConsumeAPI();
		System.out.println("========="+api.getOTP());*/
		
		File file =new File("%USERPROFILE%"+"/Downloads/test.txt");
		try(FileWriter writer=new FileWriter(file);) {
			System.out.println("===="+(writer!=null));
			writer.write("Hellooooo.......!!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
