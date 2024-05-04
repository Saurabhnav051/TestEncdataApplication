package com.epay.encdata.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.epay.encdata.config.AES256Bit;
import com.epay.encdata.entity.Adddata;
import com.epay.encdata.entity.AggregatorHosted;
import com.epay.encdata.entity.MerchantDetailEntity;
import com.epay.encdata.entity.Order;
import com.epay.encdata.entity.OrderDetails;
import com.epay.encdata.entity.QueryApiEntity;
import com.epay.encdata.util.AESEncryptDecrypt;
import com.epay.encdata.util.GenericExceptionLog;
import com.epay.encdata.util.GetMekKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




@RestController
//@RequestMapping("/home")
public class EncRequest {

	
	
	
	
	/*
	 * @Autowired MerchantDetailImpl merchantDetail;
	 */
	
	private static SecretKeySpec secretkeyspec=null;
	
	

	
	
	GetMekKey mekKey = new GetMekKey();
	
	
	
	@GetMapping("/encDecValue")
	public String encryptDecryptValue() throws NoSuchAlgorithmException {



		String meKey="";
		String encryptedInputValue ="";
		String decryptedInputValue ="";
		
		try {
		 meKey = mekKey.getMeK();      //========================================= 1 ============================
		System.out.println("meKey >> " + meKey);
		
		
	String value1 = "ARNAV";
	String value="1000003|DOM|IN|INR|10|Other|https://uat.sbiepay.sbi/secure/sucess3.jsp|https://uat.sbiepay.sbi/secure/fail3.jsp|SBIEPAY|Wpxkk|Wpxkk|NB|ONLINE|ONLINE";
	
		
	 encryptedInputValue = AESEncryptDecrypt.encrypt(value, meKey);
	System.out.println("ARNAV Encrypted Value >> " + encryptedInputValue);
	
	
	 decryptedInputValue  = AESEncryptDecrypt.decrypt(encryptedInputValue, meKey);
	System.out.println("ARNAV Decrypted Value >> " + decryptedInputValue);
	
	
	 encryptedInputValue = AESEncryptDecrypt.encrypt(value, meKey);
		System.out.println("ARNAV Encrypted Value >> " + encryptedInputValue);
			
		}catch(Exception e ) {
			
			e.printStackTrace();
		}
		
		
		/*
		 * String encryptedVal = AES256Bit.encrypt(value, secretkeyspec);
		 * System.out.println("encryptedVal >> " + encryptedVal);
		 * 
		 * String decryptedVal = AES256Bit.decrypt(encryptedVal, secretkeyspec);
		 * System.out.println("decryptedVal >> " + decryptedVal);
		 */
		
		
		
		return decryptedInputValue;
	}
	
	
	
	@GetMapping("/test")
	public String getRequestEncdata(HttpServletRequest request,RedirectAttributes req) {
		
		
	/*	JSONObject ob = new JSONObject();
		Iterator<String> paramIterator1 = data.keySet().iterator();
		while (paramIterator1.hasNext()) {
		String keyNext = paramIterator1.next();
		String valueNext = (String) data.get(keyNext);
		try {
		ob.put(keyNext, valueNext);
	  } catch (JSONException e) {
	    GenericExceptionLog.exceptionJava(e,"Exception while putting values in JSON object : processCustomerLead() ","EncRequest");
	  }
	  }
	  
	 
   */ 
		
	/*	String kekey="YW3cTxVSMKE4Ckp7eWdNPMb84HyPklORRUoUlLMM9hE=";
		String Key="6fa9bb9d6c4649a1a6934dd9df5dc046";
    	String encVal="XavxdGVkX195/6udojw8LQggh0i/MmrTgLWW31Ylwug=";
    	String decVal=AggAesDecryptUtil.decryptText(encVal, Key);
    	System.out.println("decVal ::"+decVal);
     */  
		try {
			
		
			System.out.println(request.getParameter("testdata"));
			
		
			
		//String encdata = AES256Bit.CRMEncrypt("shital","92C336F2209922D478F3D46A54E1A2E81068AFCFE13A579711DA8A32474558B7");
		//System.out.println("data="+encdata);

	  } catch (Exception e) {
	    GenericExceptionLog.exceptionJava(e,"Exception while encrypting request : processCustomerLead() ","EncRequest");
	  }
		
	return "testdata";
	}
	
	
	@PostMapping("/order")
	public ResponseEntity<?> getDates(@Valid @RequestBody Order order) {
	  
		JSONObject ob = new JSONObject();
		System.out.println("get data="+order);
		Random random = new Random();
		long q = random.nextLong();   
		random.setSeed(1234567890);
		//order.setMerchantOrderNumber(""+q);
		 Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		  String jsonInString1= gson.toJson(order);
		 Order getorderrequest  = gson.fromJson(jsonInString1,Order.class);
		
		OrderDetails orderDetial=new OrderDetails(getorderrequest.getOrdernumber(),getorderrequest.getAmount(), getorderrequest.getMerchantid(), getorderrequest.getKey());
		orderDetial.setMerchantOrderNumber(""+q);
		
		
		
		//	List<MerchantDetailEntity> s=merchantDetail.getAllSftpReconDetails(getorderrequest.getMerchantid());
		
		
 System.out.println("get=");
		
		
		
		// Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		  String jsonInString= gson.toJson(orderDetial);
          OrderDetails getorder  = gson.fromJson(jsonInString,OrderDetails.class);
		  
		 // System.out.println(getorder.)
		return ResponseEntity.ok(getorder);
	}
	
	
	@GetMapping("/open")
    public void openBrowser(){

		/* if (Desktop.isDesktopSupported()) {*/
		      
	         //making a desktop object
	         Desktop desktop = Desktop.getDesktop();
	         System.out.println("before url=");
	         try {
	         // URI uri = new URI("https://uat.sbiepay.sbi/secure/sucess3.jsp");//AggregatorHostedListener.java
	        	 URI uri = new URI("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?merchIdVal='1000003'& EncryptTrans='dsafhbne'");//merchIdVal,EncryptTrans
	           
	        	 System.out.println("URL="+uri);
	        	 desktop.browse(uri);
	         } catch (IOException excp) {
	            excp.printStackTrace();
	         } catch (URISyntaxException excp) {
	            excp.printStackTrace();
	         }
				/* } */
    }
	
	
	

	@GetMapping("/add")
//	public int addData(@RequestBody Adddata adddata,HttpServletRequest req) {   
	public int addData(HttpServletRequest req) {
		
		System.out.println("first number"+req.getParameter("number1"));
		//System.out.println("first number"+adddata.getNumber1());
		//System.out.println("second number"+adddata.getNumber2());
	
	//return adddata.getNumber1()+adddata.getNumber2();
		return 1;
	}
	
	
	
	@PostMapping("/transaction5")
	public RedirectView getdatamethod(@RequestBody AggregatorHosted aggregatorHosted,RedirectAttributes ra,HttpServletRequest req) {   
	//public ModelAndView getdatamethod(@RequestBody AggregatorHosted aggregatorHosted,RedirectAttributes ra,HttpServletRequest req) { 
		ra.addFlashAttribute("EncryptTrans",aggregatorHosted.getEncryptTrans());
	    ra.addFlashAttribute("EncryptbillingDetails",aggregatorHosted.getEncryptbillingDetails());
	    ra.addFlashAttribute("EncryptshippingDetais",aggregatorHosted.getEncryptshippingDetais());
	    ra.addFlashAttribute("EncryptpaymentDetails",aggregatorHosted.getEncryptpaymentDetails());
	   ra.addFlashAttribute("merchIdVal",aggregatorHosted.getMerchIdVal());
	    ra.addFlashAttribute("hiddenMerchantOrderNo",aggregatorHosted.getHiddenMerchantOrderNo());
	    ra.addFlashAttribute("neftRtgsMobileNumber",aggregatorHosted.getNeftRtgsMobileNumber());
	    ra.addFlashAttribute("neftRtgsEmailId",aggregatorHosted.getNeftRtgsEmailId());
	    ra.addFlashAttribute("neftChallanExpDt",aggregatorHosted.getNeftChallanExpDt());
	    ra.addFlashAttribute("cashCustomerName",aggregatorHosted.getCashCustomerName());
	
	 
	    
	    System.out.println("get:"+aggregatorHosted.getEncryptTrans());
	    System.out.println("get:"+aggregatorHosted);
	    
	 
	    
	    System.out.println("request parameter"+ra);
	    
	    //return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?action="+req.getParameter("action"));
	    
	    
	     //System.out.println("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+aggregatorHosted.getEncryptTrans()+"&EncryptbillingDetails="+aggregatorHosted.getEncryptbillingDetails()+"&EncryptshippingDetais="+aggregatorHosted.getEncryptshippingDetais()+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");

	  
	//	return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");
	
		return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+aggregatorHosted.getEncryptTrans()+"&EncryptbillingDetails="+aggregatorHosted.getEncryptbillingDetails()+"&EncryptshippingDetais="+aggregatorHosted.getEncryptshippingDetais()+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");

		/*
		 * try { } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
	//return null;

	}
	
	
	

	
	


}


