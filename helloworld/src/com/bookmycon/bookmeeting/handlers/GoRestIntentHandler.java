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

import HttpClientRequestHandler.HttpClientGetRequestHandler;

public class GoRestIntentHandler implements RequestHandler{
	 public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("GoRest"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	        
	        String resp="";
    
        
	        String speechText="", repromptText="";

	  
//	            HttpClientPostRequestHandler obj=new HttpClientPostRequestHandler();
//	            resp = obj.postRequestHandler(favoriteColor,"2025-08-12");
	           
	            
        	HttpClientGetRequestHandler obj=new HttpClientGetRequestHandler();
	         resp = obj.getRequestHandler();

	            speechText ="This is an external api GO Rest The data is as Follow "+resp;
	                   
	     
//	        resp="your booking is confirm"+" you make booking for "+name+
//	        		" for date "+date+" From "+timeFrom+" to "+timeTo;
	        return input.getResponseBuilder()
	                .withSimpleCard("ColorSession", speechText)
//	                .withSpeech(speechText)
	                .withSpeech(speechText)
	                .withReprompt(repromptText)
	                .withShouldEndSession(false)
	                .build();
	    }

}
