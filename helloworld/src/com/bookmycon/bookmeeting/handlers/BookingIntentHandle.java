package com.bookmycon.bookmeeting.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
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
import HttpClientRequestHandler.HttpClientPostRequestHandler;
import ngrokLink.NgrokLink;

public class BookingIntentHandle  implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("BookingIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String resp="";
        // Get the color slot from user input.
       Slot nameSlot = slots.get("Name");
        Slot dateSlot = slots.get("Date");
        Slot timeFromSlot = slots.get("TimeFrom");
        Slot timeToSlot = slots.get("TimeTo");
        
        
        String name = nameSlot.getValue();
        String date = dateSlot.getValue();
        String timeFrom = timeFromSlot.getValue();
        String timeTo = timeToSlot.getValue();
        
//        HttpClientPostRequestHandler obj=new HttpClientPostRequestHandler();
//        resp=obj.postRequestHandlerBookingIntent(name, date, timeFrom, timeTo);

        

		 String uri=NgrokLink.getLink()+"/Alexa/bookingIntent";
			 String data1="{\"BookingObjAuditoriamName\":\""+name+"\",\"BookingObjDate\":\""+date+
					 "\",\"BookingObjTimeFrom\":\""+timeFrom+"\",\"BookingTimeTo\":\""+timeTo+"\"}";
//			 String data1="{\"aduitoriamName\":\""+auditoriamName+"\",\"bookingDateFrom\":\""+date+"\"}";
			 
			 String sendResp="No place give information";
//		 String data="{\"aduitoriamName\":\"ok\",\"bookingDateFrom\":\"2023-04-01\"}";
		 HttpRequest req=HttpRequest.newBuilder()
				 .uri(URI.create(uri))
				 .header("Content-Type", "application/json")
				 .POST(BodyPublishers.ofString(data1))
				 .version(Version.HTTP_2)
				 .build();
		
		 
		 HttpClient client=HttpClient.newBuilder().build();
		
		 try {
		HttpResponse<String> resp1 =client.send(req, BodyHandlers.ofString());
		System.out.println(resp1.statusCode());
		System.out.println(resp1.body());
		sendResp=resp1.body().toString();
		resp=resp1.body().toString();
		 } catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		
        
        
        
        
        
        
        
        
        
        
        
        
        //        String speechText="", repromptText="";

//      input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_Name_KEY, name));
//      input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_Date_KEY, date));
//      input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_TimeFrom_KEY, timeFrom));
//      input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HelloWorldIntentHandler.COLOR_TimeTo_KEY, timeTo));
      
        // Check for favorite color and create output to user.
//        if(favoriteColorSlot != null
//            && favoriteColorSlot.getResolutions() != null
//            && favoriteColorSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
//            // Store the user's favorite color in the Session and create response.
//            String favoriteColor = favoriteColorSlot.getValue();
//            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(WhatsMyColorIntentHandler.COLOR_KEY, favoriteColor));

//            HttpClientPostRequestHandler obj=new HttpClientPostRequestHandler();
//            resp = obj.postRequestHandler(favoriteColor,"2025-08-12");
           
            
//HttpClientGetRequestHandler obj=new HttpClientGetRequestHandler();
//         resp = obj.getRequestHandler();

//            speechText =
//                    String.format("I now know that your favorite color is %s. You can ask me your "
//                            + "favorite color by saying, what's my favorite color?", favoriteColor);
//            repromptText =
//                    "You can ask me your favorite color by saying, what's my favorite color?";
//
//        } else {
//            // Render an error since user input is out of list of color defined in interaction model.
//            speechText = "Please provide a valid color, your options are green, blue, purple, red, orange and yellow. " +
//                    "Please try again.";
//            repromptText =
//                    "I'm not sure what your favorite color is. You can tell me your favorite "
//                            + "color by saying, my color is red.";
//        }

        resp=resp+"your booking is confirm"+" you make booking for "+name+
        		" for date "+date+" From "+timeFrom+" to "+timeTo;
      return input.getResponseBuilder()
                .withSimpleCard("BookingIntent", resp)
//                .withSpeech(speechText)
                .withSpeech(resp)
                .withReprompt(resp)
                .withShouldEndSession(false)
                .build();
    }
}
