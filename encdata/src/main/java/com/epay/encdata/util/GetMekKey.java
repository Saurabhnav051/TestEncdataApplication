package com.epay.encdata.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.epay.encdata.config.AES128Bit;
import com.epay.encdata.config.AES256Bit;

public class GetMekKey {

	
	public String getMeK() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException
	{
		//String aggregatorId = values.get(0) == null ? "" : values.get(0).toString();
		String aggregatorId = "SBIEPAY";             //========================================= 2 ============================
		String merchantId = "1000003";
		//String merchantId = values.get(1) == null ? "" : values.get(1).toString();
		ArrayList KeKList = new ArrayList();
		String AeK = "", kekEncry = "", KeK = "", mekEncry = "", MeK = "";

		FileInputStream fstream = null;
		DataInputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		// reading the AeK value for the aggregator id
		try {
			
			
			
			fstream = new FileInputStream("/jboss/app-config/payagg/keys/SBIEPAY.key");  // --------- UAT key for decrypt kekEncry encrypted value from database
			in = new DataInputStream(fstream);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String strLine;
			int i = 1;
			while ((strLine = br.readLine()) != null) {
				AeK = strLine;
			}
			
			in.close();
		}
		
		catch (NullPointerException e)
		{
			GenericExceptionLog.exceptionJava(e, "AggRegenerateMerchantKey.java", "AggRegenerateMerchantKey");
		}
		catch (IOException e)
		{
			GenericExceptionLog.exceptionJava(e, "AggRegenerateMerchantKey.java", "AggRegenerateMerchantKey");
		}
		catch (Exception e)
		{
			GenericExceptionLog.exceptionJava(e, "AggRegenerateMerchantKey.java", "AggRegenerateMerchantKey");
		} finally {
			try {
				fstream.close();
				in.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				GenericExceptionLog.exceptionJava(e, "Exception while closing files", "AggRegenerateMerchantKey");
			}
			fstream = null;
			in = null;
			isr = null;
			br = null;
		}

		StringBuffer sql=new StringBuffer(10);
		ArrayList queryValues=new ArrayList();
		ArrayList queryType=new ArrayList();
		String[] KeKValue=new String[1];
		
		String aes128Flag="AES128";
		kekEncry = ""; //------------ encrypted value from database 
		
		
		
		try {
		KeK=AES128Bit.decrypt(kekEncry, AeK);
		System.out.println("kek >> " + KeK);
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		try {
			
			mekEncry="";
	
			
			MeK = AES128Bit.decrypt(mekEncry, KeK);
		System.out.println("MeK >> " + MeK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return MeK;
	}
	
	
	
	public String getMeK(String getmerid,String getkekEncry,String getmekEncry) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException
	{
		//String aggregatorId = values.get(0) == null ? "" : values.get(0).toString();
		String aggregatorId = "SBIEPAY";             //========================================= 2 ============================
		String merchantId = getmerid;
		//String merchantId = values.get(1) == null ? "" : values.get(1).toString();
		ArrayList KeKList = new ArrayList();
		String AeK = "", kekEncry = "", KeK = "", mekEncry = "", MeK = "";

	
		// reading the AeK value for the aggregator id
		try {
			
		
			AeK="F/FB1LScrMizBTKp84ScUg==";
			
		}
		
		catch (NullPointerException e)
		{
			GenericExceptionLog.exceptionJava(e, "AggRegenerateMerchantKey.java", "AggRegenerateMerchantKey");
		}
		catch (Exception e)
		{
			GenericExceptionLog.exceptionJava(e, "AggRegenerateMerchantKey.java", "AggRegenerateMerchantKey");
		} finally {
			
		}

		StringBuffer sql=new StringBuffer(10);
		ArrayList queryValues=new ArrayList();
		ArrayList queryType=new ArrayList();
		String[] KeKValue=new String[1];
		
		String aes128Flag="AES128";
		kekEncry = getkekEncry; //------------ encrypted value from database 
		
		
		
		try {
		KeK=AES128Bit.decrypt(kekEncry, AeK);
		System.out.println("kek >> " + KeK);
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		try {
			
			mekEncry=getmekEncry;
	
			
			MeK = AES128Bit.decrypt(mekEncry, KeK);
		System.out.println("MeK >> " + MeK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return MeK;
	}

}
