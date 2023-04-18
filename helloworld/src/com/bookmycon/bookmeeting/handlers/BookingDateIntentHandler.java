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

public class BookingDateIntentHandler  implements RequestHandler{
	 
	String data;
	String speechText ="";
	
//		@Autowired
//		private WebClientService webClientService;
	//	
	    @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("BookingDate"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	  	  Request request = input.getRequestEnvelope().getRequest();
          IntentRequest intentRequest = (IntentRequest) request;
          Intent intent = intentRequest.getIntent();
          Map<String, Slot> slots = intent.getSlots();
         
          Slot bookingDateSlot = slots.get(BookingTimeIntentHandler.COLOR_BookingDateIntent_SLOT);
//          String bookingNameSession = (String) input.getAttributesManager().getSessionAttributes().get(COLOR_BookingNameIntent_KEY);
//          String datena = (String) input.getAttributesManager().getSessionAttributes().get(BookingTimeIntentHandler.DateNameKey);
//          
          String bookingDate = bookingDateSlot.getValue();
          HttpClientPostRequestHandler obj=new HttpClientPostRequestHandler();
          speechText=obj.postRequestHandlerBookingDate(bookingDate);
//          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(BookingTimeIntentHandler.COLOR_BookingDateIntent_KEY, bookingDate));
          
//          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(BookingTimeIntentHandler.COLOR_BookingDateIntent_KEY, bookingDate));
//          input.getAttributesManager().setSessionAttributes(Collections.singletonMap(BookingTimeIntentHandler.DateNameKey2, datena));
//          
//	    	 speechText ="you can tall time by saying from time to time";

	        return input.getResponseBuilder()
	                .withSpeech(speechText)
	                .withSimpleCard("HelloWorld", speechText)
	                .build();
	       
	    }
}
