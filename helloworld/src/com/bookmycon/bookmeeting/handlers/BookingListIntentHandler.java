package com.bookmycon.bookmeeting.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import HttpClientRequestHandler.HttpClientGetRequestHandler;

public class BookingListIntentHandler implements RequestHandler {
	String data;

	String speechText ="" ;
//		@Autowired
//		private WebClientService webClientService;
	//	
	    @Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("BookingList"));
	    }

	    @Override
	    public Optional<Response> handle(HandlerInput input) {
	    
       	HttpClientGetRequestHandler obj=new HttpClientGetRequestHandler();
        	speechText = obj.listOfAuditorium();

	   
	        return input.getResponseBuilder()
	                .withSpeech(speechText)
	                .withSimpleCard("HelloWorld", speechText)
	                .build();
	    }
}
