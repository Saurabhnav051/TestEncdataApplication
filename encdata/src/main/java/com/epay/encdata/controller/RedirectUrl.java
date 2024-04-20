package com.epay.encdata.controller;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.epay.encdata.entity.AggregatorHosted;
import com.epay.encdata.util.AESEncryptDecrypt;
import com.epay.encdata.util.GetMekKey;

//import com.epay.encdata.entity.Adddata;





@Controller
public class RedirectUrl {

	@GetMapping("/redirect")
	public RedirectView redirectWithRedirectAttributes() {
	//public RedirectView redirectWithRedirectAttributes(RedirectAttributes attributes) {
	   // attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectAttributes");
	    //attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
	    return new RedirectView("https://uat.sbiepay.sbi/secure/aggFailure.jsp?encData=6jPckkZEN7QcUt9c4Cyu3MBdpSxjLXzHYRmcosZZ%2BDEe2PUCMmghBMzMvwzrWaZ4Ix%2BKATnXm%2FQg0goUVp3O%2FcD3bNfxkyavKA6O%2BYHNqeGRZDEEAWaWz4v35WNmm8yB79I%2B53CwhAD9ghKbFsIeVbW7HnCaKOzWD0grVN%2FrMDZnUdKtZtJoGhQh7%2FJcj96hn13vHhjaP7jdHvdEqItRrA%3D%3D&Bank_Code=1000003&merchIdVal=1000003&errorCode=PayAggApplication&merchantName=MAHAONLINE&error=Your+session+has+expired.+Please+re-attempt+the+transaction.#no-back-button");
	}
	
	@PostMapping("/transaction")
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
	
	   // ra.addFlashAttribute("action","AggregatorHostedListener");
	 
	/*	 
	    ra.addAttribute("encryptTrans",aggregatorHosted.getEncryptTrans());
	    ra.addAttribute("encryptbillingDetails",aggregatorHosted.getEncryptbillingDetails());
	    ra.addAttribute("encryptshippingDetais",aggregatorHosted.getEncryptshippingDetais());
	    ra.addAttribute("encryptpaymentDetails",aggregatorHosted.getEncryptpaymentDetails());
	    ra.addAttribute("merchIdVal",aggregatorHosted.getMerchIdVal());
	    ra.addAttribute("hiddenMerchantOrderNo",aggregatorHosted.getHiddenMerchantOrderNo());
	    ra.addAttribute("neftRtgsMobileNumber",aggregatorHosted.getNeftRtgsMobileNumber());
	    ra.addAttribute("neftRtgsEmailId",aggregatorHosted.getNeftRtgsEmailId());
	    ra.addAttribute("neftChallanExpDt",aggregatorHosted.getNeftChallanExpDt());
	    ra.addAttribute("cashCustomerName",aggregatorHosted.getCashCustomerName());
	  */
	  //  return new RedirectView("redirect:/item");
	    
	    System.out.println("get:"+aggregatorHosted.getEncryptTrans());
	    System.out.println("get:"+aggregatorHosted);
	    
	 
	    
	    System.out.println("request parameter"+ra);
	    
	    //return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?action="+req.getParameter("action"));
	    
	    
	     //System.out.println("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+aggregatorHosted.getEncryptTrans()+"&EncryptbillingDetails="+aggregatorHosted.getEncryptbillingDetails()+"&EncryptshippingDetais="+aggregatorHosted.getEncryptshippingDetais()+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");

	   try {
		return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");
		  // return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener");
		
		
	   
	   } //catch (UnsupportedEncodingException e) {
	   catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

	}
	
	
	
	
	
	@PostMapping("/transaction1")
	public String getdatamethod1(@ModelAttribute AggregatorHosted aggregatorHosted, Model ra) {    				 
	    ra.addAttribute("encryptTrans",aggregatorHosted.getEncryptTrans());
	    ra.addAttribute("encryptbillingDetails",aggregatorHosted.getEncryptbillingDetails());
	    ra.addAttribute("encryptshippingDetais",aggregatorHosted.getEncryptshippingDetais());
	    ra.addAttribute("encryptpaymentDetails",aggregatorHosted.getEncryptpaymentDetails());
	    ra.addAttribute("merchIdVal",aggregatorHosted.getMerchIdVal());
	    ra.addAttribute("hiddenMerchantOrderNo",aggregatorHosted.getHiddenMerchantOrderNo());
	    ra.addAttribute("neftRtgsMobileNumber",aggregatorHosted.getNeftRtgsMobileNumber());
	    ra.addAttribute("neftRtgsEmailId",aggregatorHosted.getNeftRtgsEmailId());
	    ra.addAttribute("neftChallanExpDt",aggregatorHosted.getNeftChallanExpDt());
	    ra.addAttribute("cashCustomerName",aggregatorHosted.getCashCustomerName());
	  
	  //  return new RedirectView("redirect:/item");
	    
	    System.out.println("get:"+aggregatorHosted.getEncryptTrans());
	    System.out.println("get:"+aggregatorHosted);
	    
	   // System.out.println("getdata"+req.getParameter("action"));
	    
	    System.out.println("request parameter"+ra);
	    
	    
	    return "transaction";
	   // return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?action="+req.getParameter("action"));
	}
	
	
	
	
	@GetMapping("/transaction2")
	public RedirectView getdatamethod2(HttpServletRequest req) {   
	//public ModelAndView getdatamethod(@RequestBody AggregatorHosted aggregatorHosted,RedirectAttributes ra,HttpServletRequest req) { 
		
		AggregatorHosted aggregatorHosted=new AggregatorHosted();
		
		aggregatorHosted.setEncryptTrans(req.getParameter("encryptTrans"));
		aggregatorHosted.setEncryptpaymentDetails("WkWBvgYaMjvLzvyZsnzIzA==");
		aggregatorHosted.setEncryptTrans("1000003");
		aggregatorHosted.setEncryptTrans(req.getParameter("hiddenMerchantOrderNo"));
	
		
		System.out.println("hello "+req.getParameter("encryptTrans"));
		System.out.println("hello2 "+req.getParameter("hiddenMerchantOrderNo"));
		
		    
	    System.out.println("get:"+aggregatorHosted.getEncryptTrans());
	    System.out.println("get:"+aggregatorHosted);
	    
	 
	    
	    //System.out.println("request parameter"+ra);
	    
	    //return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?action="+req.getParameter("action"));
	    
	    
	     //System.out.println("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+aggregatorHosted.getEncryptTrans()+"&EncryptbillingDetails="+aggregatorHosted.getEncryptbillingDetails()+"&EncryptshippingDetais="+aggregatorHosted.getEncryptshippingDetais()+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");

	   try {
		return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

	}
	

	
	
	
	@PostMapping("/callredirect")
	public RedirectView redirectcallredirect(HttpServletRequest req) {
	
		
		
		GetMekKey mekKey = new GetMekKey();
		
		String meKey="";
		String encryptedInputValue ="";
		String decryptedInputValue ="";
		String ordernumber=req.getParameter("hiddenMerchantOrderNo");
		String orderAmount=req.getParameter("orderAmount");
		String mk=req.getParameter("mk");
		String kk=req.getParameter("kk");
		
		try {
		// meKey = mekKey.getMeK();      //========================================= 1 ============================//
			 meKey= mekKey.getMeK("1000003",kk,mk);
		System.out.println("meKey >> " + meKey);
		
		
	String value1 = "ARNAV";
	String value="1000003|DOM|IN|INR|"+orderAmount+"|Other|https://uat.sbiepay.sbi/secure/sucess3.jsp|https://uat.sbiepay.sbi/secure/fail3.jsp|SBIEPAY|"+ordernumber+"|"+ordernumber+"|NB|ONLINE|ONLINE";
	
		
	 encryptedInputValue = AESEncryptDecrypt.encrypt(value, meKey);
	System.out.println("ARNAV Encrypted Value >> " + encryptedInputValue);
		
}catch(Exception e ) {
			
			e.printStackTrace();
		}
		
		
		
AggregatorHosted aggregatorHosted=new AggregatorHosted();
		
		aggregatorHosted.setEncryptTrans(encryptedInputValue);
		aggregatorHosted.setEncryptpaymentDetails("WkWBvgYaMjvLzvyZsnzIzA==");
		aggregatorHosted.setMerchIdVal("1000003");
		aggregatorHosted.setEncryptbillingDetails("");
		aggregatorHosted.setEncryptshippingDetais("");
		aggregatorHosted.setHiddenMerchantOrderNo(ordernumber);
		
	 
		  try {
				return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	
	}
	
	public RedirectView redirectCall(String hiddenMerchantOrderNo,String orderAmount1,String mk,String kk ) {
	
		
		
		GetMekKey mekKey = new GetMekKey();
		
		String meKey="";
		String encryptedInputValue ="";
		String decryptedInputValue ="";
		String ordernumber=hiddenMerchantOrderNo;
		String orderAmount=orderAmount1;
		String mk1=mk;
		String kk1=kk;
		
		try {
		// meKey = mekKey.getMeK();      //========================================= 1 ============================//
			 meKey= mekKey.getMeK("1000003",kk1,mk1);
		System.out.println("meKey >> " + meKey);
		
		
	String value1 = "ARNAV";
	String value="1000003|DOM|IN|INR|"+orderAmount+"|Other|https://uat.sbiepay.sbi/secure/sucess3.jsp|https://uat.sbiepay.sbi/secure/fail3.jsp|SBIEPAY|"+ordernumber+"|"+ordernumber+"|NB|ONLINE|ONLINE";
	
		
	 encryptedInputValue = AESEncryptDecrypt.encrypt(value, meKey);
	System.out.println("ARNAV Encrypted Value >> " + encryptedInputValue);
		
}catch(Exception e ) {
			
			e.printStackTrace();
		}
		
		
		
AggregatorHosted aggregatorHosted=new AggregatorHosted();
		
		aggregatorHosted.setEncryptTrans(encryptedInputValue);
		aggregatorHosted.setEncryptpaymentDetails("WkWBvgYaMjvLzvyZsnzIzA==");
		aggregatorHosted.setMerchIdVal("1000003");
		aggregatorHosted.setEncryptbillingDetails("");
		aggregatorHosted.setEncryptshippingDetais("");
		aggregatorHosted.setHiddenMerchantOrderNo(ordernumber);
		
	 
		  try {
				return new RedirectView("https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	
	}

	public String redirectCall2(String hiddenMerchantOrderNo,String orderAmount1,String mk,String kk ) {
	
		
		
		GetMekKey mekKey = new GetMekKey();
		
		String meKey="";
		String encryptedInputValue ="";
		String decryptedInputValue ="";
		String ordernumber=hiddenMerchantOrderNo;
		String orderAmount=orderAmount1;
		String mk1=mk;
		String kk1=kk;
		
		try {
		// meKey = mekKey.getMeK();      //========================================= 1 ============================//
			 meKey= mekKey.getMeK("1000003",kk1,mk1);
		System.out.println("meKey >> " + meKey);
		
		
	String value1 = "ARNAV";
	String value="1000003|DOM|IN|INR|"+orderAmount+"|Other|https://uat.sbiepay.sbi/secure/sucess3.jsp|https://uat.sbiepay.sbi/secure/fail3.jsp|SBIEPAY|"+ordernumber+"|"+ordernumber+"|NB|ONLINE|ONLINE";
	
		
	 encryptedInputValue = AESEncryptDecrypt.encrypt(value, meKey);
	System.out.println("ARNAV Encrypted Value >> " + encryptedInputValue);
		
}catch(Exception e ) {
			
			e.printStackTrace();
		}
		
		
		
AggregatorHosted aggregatorHosted=new AggregatorHosted();
		
		aggregatorHosted.setEncryptTrans(encryptedInputValue);
		aggregatorHosted.setEncryptpaymentDetails("WkWBvgYaMjvLzvyZsnzIzA==");
		aggregatorHosted.setMerchIdVal("1000003");
		aggregatorHosted.setEncryptbillingDetails("");
		aggregatorHosted.setEncryptshippingDetais("");
		aggregatorHosted.setHiddenMerchantOrderNo(ordernumber);
		
	 
		  try {
				return "https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	
	}
	
}
