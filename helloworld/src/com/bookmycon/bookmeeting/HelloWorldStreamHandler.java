/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.bookmycon.bookmeeting;


import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.bookmycon.bookmeeting.handlers.BookingDateIntentHandler;
import com.bookmycon.bookmeeting.handlers.BookingIntentHandle;
import com.bookmycon.bookmeeting.handlers.BookingListIntentHandler;
import com.bookmycon.bookmeeting.handlers.BookingNameDateIntent;
import com.bookmycon.bookmeeting.handlers.BookingNameIntentHandler;
import com.bookmycon.bookmeeting.handlers.BookingTimeIntentHandler;
import com.bookmycon.bookmeeting.handlers.CancelandStopIntentHandler;
import com.bookmycon.bookmeeting.handlers.HelloWorldIntentHandler;
import com.bookmycon.bookmeeting.handlers.HelpIntentHandler;
import com.bookmycon.bookmeeting.handlers.SessionEndedRequestHandler;
import com.bookmycon.bookmeeting.handlers.WhatsMyColorIntentHandler;
import com.bookmycon.bookmeeting.handlers.LaunchRequestHandler;
import com.bookmycon.bookmeeting.handlers.MyColorIsIntentHandler;
import com.bookmycon.bookmeeting.handlers.SampleIntentHandler;
import com.bookmycon.bookmeeting.handlers.FallbackIntentHandler;
import com.bookmycon.bookmeeting.handlers.GoRestIntentHandler;

public class HelloWorldStreamHandler extends SkillStreamHandler {

	
    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelloWorldIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler(),
                        new BookingIntentHandle(),
                        new SampleIntentHandler(),
                        new MyColorIsIntentHandler(),
                        new WhatsMyColorIntentHandler(),
                        new BookingIntentHandle(),
                        new BookingDateIntentHandler(),
                        new BookingListIntentHandler(),
                        new BookingNameIntentHandler(),
                        new BookingTimeIntentHandler(),
                        new GoRestIntentHandler(),
                        new BookingNameDateIntent())
                // Add your skill id below
                .withSkillId("amzn1.ask.skill.29196d80-8bbb-483b-9191-939a58451fde")
                .build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }

}
