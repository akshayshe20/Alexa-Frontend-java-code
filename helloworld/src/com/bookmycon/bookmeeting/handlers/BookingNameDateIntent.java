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

public class BookingNameDateIntent implements RequestHandler {
	 
	String data;
	String speechText ="" ;
//		@Autowired
//		private WebClientService webClientService;
	//	
	    @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("BookingNameDateIntent"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	      
	    	  Request request = input.getRequestEnvelope().getRequest();
	          IntentRequest intentRequest = (IntentRequest) request;
	          Intent intent = intentRequest.getIntent();
	          Map<String, Slot> slots = intent.getSlots();
	         
	          Slot bookingNameSlot = slots.get(BookingTimeIntentHandler.BookingNameIntent_SLOT);
	           Slot bookingDateSlot = slots.get(BookingTimeIntentHandler.BookingDateIntent_SLOT);
//	          
	          
//	          if(bookingNameSlot == null) {
//	        	  speechText="your input is not register, please try again";
//	        	  return input.getResponseBuilder()
//	  	                .withSpeech(speechText)
//	  	                .withSimpleCard("HelloWorld", speechText)
//	  	                .build();
//	          }
	          String bookingName = bookingNameSlot.getValue();
	          String bookingDate = bookingDateSlot.getValue();
		         
	          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(BookingTimeIntentHandler.BookingNameIntent_KEY, bookingName));
	          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(BookingTimeIntentHandler.BookingDateIntent_KEY, bookingDate));
		      
	              
	          speechText ="you can say for date  to make booking for date"+"booking name:-"+bookingName;

	        return input.getResponseBuilder()
	                .withSpeech(speechText)
	                .withSimpleCard("HelloWorld", speechText)
	                .build();
	       
	    }
}
