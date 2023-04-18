package com.bookmycon.bookmeeting.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import HttpClientRequestHandler.HttpClientPostRequestHandler;
     
//	
//public class BookingTimeIntentHandler  implements RequestHandler{
//	  public static final String COLOR_BookingNameIntent_SLOT = "BookingNameIntent";
//	  public static final  String COLOR_BookingNameIntent_KEY = "BOOKINGNAMEINTENT";
//	  
//	public static final String COLOR_BookingDateIntent_KEY = "BOOKINGDATEINTENT";
//	    public static final  String COLOR_BookingDateIntent_SLOT = "BookingDateIntent";
//	    public static final  String COLOR_BookingTimeFromIntent_KEY = "BOOKINGTIMEFROMINTENT";
//	    public static final String COLOR_BookingTimeFromIntent_SLOT = "BookingTimeFromIntent";
//	    public static final String COLOR_BookingTimeToIntent_KEY = "BOOKINGTIMETOINTENT";
//	    public static final String COLOR_BookingTimeToIntent_SLOT = "BookingTimeToIntent";
//	    public static final String DateNameKey = "dateName";
//	    public static final String DateNameKey2 = "dateName";
//	
//	    
//	public static final String BookingNameIntent_KEY = "DATENAME";
//	    public static final  String BookingNameIntent_SLOT = "DateName";
//	     
//	public static final String BookingDateIntent_KEY = "DATEDATE";
//	    public static final  String BookingDateIntent_SLOT = "DateDate";
//	     
//	    String data;
//	String speechText ="" ;
////		@Autowired
////		private WebClientService webClientService;
//	//	
//	    @Override
//	    public boolean canHandle(HandlerInput input) {
//	        return input.matches(intentName("BookingTimeIntent"));
//	    }
//
//	    @Override
//	    public Optional<Response> handle(HandlerInput input) {
//
//	    	  Request request = input.getRequestEnvelope().getRequest();
//	          IntentRequest intentRequest = (IntentRequest) request;
//	          Intent intent = intentRequest.getIntent();
//	          Map<String, Slot> slots = intent.getSlots();
//	         
//	          Slot bookingTimeFromSlot = slots.get(BookingTimeIntentHandler.COLOR_BookingTimeFromIntent_SLOT);
//	          Slot bookingTimeToSlot = slots.get(BookingTimeIntentHandler.COLOR_BookingTimeToIntent_SLOT);
//	          
//	          if(bookingTimeFromSlot == null || bookingTimeToSlot == null ) {
//	        	  
//	          
//	        	  speechText="your input is not register, please try again";
//	        	  return input.getResponseBuilder()
//	  	                .withSpeech(speechText)
//	  	                .withSimpleCard("HelloWorld", speechText)
//	  	                .build();
//	          }
//	          String bookingTimeFrom = bookingTimeFromSlot.getValue();
//	          String bookingTimeTo = bookingTimeToSlot.getValue();
//	   	   
////	          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_BookingTimeFromIntent_KEY, bookingTimeFrom));
////	          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_BookingTimeToIntent_KEY, bookingTimeTo));
//	          String bookingName = (String) input.getAttributesManager().getSessionAttributes().get(BookingTimeIntentHandler.COLOR_BookingNameIntent_KEY);
//	          String bookingDate = (String) input.getAttributesManager().getSessionAttributes().get(BookingTimeIntentHandler.COLOR_BookingDateIntent_KEY);
//
////	          String bookingDateSession = (String) input.getAttributesManager().getSessionAttributes().get(BookingTimeIntentHandler.COLOR_BookingDateIntent_KEY);
//
//	    	 speechText ="your booking is confirm. Thank you, " 
//	    	    +" you make booking for "+bookingName+
//	            		" for date "+bookingDate+" From "+bookingTimeFrom+" to "+bookingTimeTo;
//	           
//	        return input.getResponseBuilder()
//	                .withSpeech(speechText)
//	                .withSimpleCard("HelloWorld", speechText)
//	                .build();
//	       
//	    }
//}




public class BookingTimeIntentHandler  implements RequestHandler{
	  public static final String COLOR_BookingNameIntent_SLOT = "BookingNameIntent";
	  public static final  String COLOR_BookingNameIntent_KEY = "BOOKINGNAMEINTENT";
	  
	public static final String COLOR_BookingDateIntent_KEY = "BOOKINGDATEINTENT";
	    public static final  String COLOR_BookingDateIntent_SLOT = "BookingDateIntent";
	    public static final  String COLOR_BookingTimeFromIntent_KEY = "BOOKINGTIMEFROMINTENT";
	    public static final String COLOR_BookingTimeFromIntent_SLOT = "BookingTimeFromIntent";
	    public static final String COLOR_BookingTimeToIntent_KEY = "BOOKINGTIMETOINTENT";
	    public static final String COLOR_BookingTimeToIntent_SLOT = "BookingTimeToIntent";
	    public static final String DateNameKey = "dateName";
	    public static final String DateNameKey2 = "dateName";
	
	    
	     
	public static final String BookingNameIntent_KEY = "DATENAME";
	    public static final  String BookingNameIntent_SLOT = "DateName";
	     
	public static final String BookingDateIntent_KEY = "DATEDATE";
	    public static final  String BookingDateIntent_SLOT = "DateDate";
	     
	    String data;
	String speechText ="" ;
//		@Autowired
//		private WebClientService webClientService;
	//	
	    @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("BookingTimeIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {

	    	  Request request = input.getRequestEnvelope().getRequest();
	          IntentRequest intentRequest = (IntentRequest) request;
	          Intent intent = intentRequest.getIntent();
	          Map<String, Slot> slots = intent.getSlots();
	         
	          Slot bookingTimeFromSlot = slots.get(BookingTimeIntentHandler.COLOR_BookingTimeFromIntent_SLOT);
	          Slot bookingTimeToSlot = slots.get(BookingTimeIntentHandler.COLOR_BookingTimeToIntent_SLOT);
//	          
//	          if(bookingTimeFromSlot == null || bookingTimeToSlot == null ) {
//	        	  
//	          
//	        	  speechText="your input is not register, please try again";
//	        	  return input.getResponseBuilder()
//	  	                .withSpeech(speechText)
//	  	                .withSimpleCard("HelloWorld", speechText)
//	  	                .build();
//	          }
	          String bookingTimeFrom = bookingTimeFromSlot.getValue();
	          String bookingTimeTo = bookingTimeToSlot.getValue();
	   	   HttpClientPostRequestHandler obj=new HttpClientPostRequestHandler();
	   	   speechText=obj.postRequestHandlerFromTimeToTime(bookingTimeFrom, bookingTimeTo);
//	          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_BookingTimeFromIntent_KEY, bookingTimeFrom));
//	          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_BookingTimeToIntent_KEY, bookingTimeTo));
	          String bookingName = (String) input.getAttributesManager().getSessionAttributes().get(BookingTimeIntentHandler.COLOR_BookingNameIntent_KEY);
	          String bookingDate = (String) input.getAttributesManager().getSessionAttributes().get(BookingTimeIntentHandler.COLOR_BookingDateIntent_KEY);

//	          String bookingDateSession = (String) input.getAttributesManager().getSessionAttributes().get(BookingTimeIntentHandler.COLOR_BookingDateIntent_KEY);

//	    	 speechText ="your booking is confirm. Thank you, " 
//	    	    +" you make booking for "+bookingName+
//	            		" for date "+bookingDate+" From "+bookingTimeFrom+" to "+bookingTimeTo;
//	           
	        return input.getResponseBuilder()
	                .withSpeech(speechText)
	                .withSimpleCard("HelloWorld", speechText)
	                .build();
	       
	    }
}
