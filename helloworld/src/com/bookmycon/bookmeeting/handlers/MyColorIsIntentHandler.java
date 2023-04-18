/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.bookmycon.bookmeeting.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import HttpClientRequestHandler.HttpClientGetRequestHandler;
import HttpClientRequestHandler.HttpClientPostRequestHandler;


import java.util.Collections;

import java.util.Map;
import java.util.Optional;


import static com.amazon.ask.request.Predicates.intentName;

public class MyColorIsIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("MyColorIsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String resp="";
        // Get the color slot from user input.
        Slot favoriteColorSlot = slots.get(WhatsMyColorIntentHandler.COLOR_SLOT);
//        Slot nameSlot = slots.get(WhatsMyColorIntentHandler.COLOR_Name_SLOT);
//        Slot dateSlot = slots.get(WhatsMyColorIntentHandler.COLOR_Date_SLOT);
//        Slot timeFromSlot = slots.get(WhatsMyColorIntentHandler.COLOR_TimeFrom_SLOT);
//        Slot timeToSlot = slots.get(WhatsMyColorIntentHandler.COLOR_TimeTo_SLOT);
//        
        
//        String name = nameSlot.getValue();
//        String date = dateSlot.getValue();
//        String timeFrom = timeFromSlot.getValue();
//        String timeTo = timeToSlot.getValue();
        
        
        String speechText, repromptText;

        // Check for favorite color and create output to user.
        if(favoriteColorSlot != null
            && favoriteColorSlot.getResolutions() != null
            && favoriteColorSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
            // Store the user's favorite color in the Session and create response.
            String favoriteColor = favoriteColorSlot.getValue();
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(WhatsMyColorIntentHandler.COLOR_KEY, favoriteColor));

//            HttpClientPostRequestHandler obj=new HttpClientPostRequestHandler();
//            resp = obj.postRequestHandler(favoriteColor,"2025-08-12");
           
            
HttpClientGetRequestHandler obj=new HttpClientGetRequestHandler();
         resp = obj.getRequestHandler();

            speechText =
                    String.format("I now know that your favorite color is %s. You can ask me your "
                            + "favorite color by saying, what's my favorite color?", favoriteColor);
            repromptText =
                    "You can ask me your favorite color by saying, what's my favorite color?";

        } else {
            // Render an error since user input is out of list of color defined in interaction model.
            speechText = "Please provide a valid color, your options are green, blue, purple, red, orange and yellow. " +
                    "Please try again.";
            repromptText =
                    "I'm not sure what your favorite color is. You can tell me your favorite "
                            + "color by saying, my color is red.";
        }

//        resp="your booking is confirm"+" you make booking for "+name+
//        		" for date "+date+" From "+timeFrom+" to "+timeTo;
        return input.getResponseBuilder()
                .withSimpleCard("ColorSession", speechText)
//                .withSpeech(speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }

}
