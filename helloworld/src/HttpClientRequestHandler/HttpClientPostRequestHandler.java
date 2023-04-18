package HttpClientRequestHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;

import ngrokLink.NgrokLink;

public class HttpClientPostRequestHandler {
	NgrokLink ngrokLink;
	
	public  String postRequestHandlerBookingName(String auditoriamName) {
    	
		 String uri=ngrokLink.getLink()+"/Alexa/bookingAuditoriamName";
			 String data1="{\"auditoriamName\":\""+auditoriamName+"\"}";
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
		HttpResponse<String> resp =client.send(req, BodyHandlers.ofString());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		sendResp=resp.body().toString();
		 } catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		 return sendResp;
    }

	public  String postRequestHandlerBookingDate(String date) {
    	
		 String uri=ngrokLink.getLink()+"/Alexa/bookingDate";
			 String data1="{\"date\":\""+date+"\"}";
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
		HttpResponse<String> resp =client.send(req, BodyHandlers.ofString());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		sendResp=resp.body().toString();
		 } catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		 return sendResp;
    }


	public  String postRequestHandlerFromTimeToTime(String fromTime,String toTime) {
    	
		 String uri=ngrokLink.getLink()+"/Alexa/bookingTime";
			 String data1="{\"timeFrom\":\""+fromTime+"\",\"timeTo\":\""+toTime+"\"}";
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
		HttpResponse<String> resp =client.send(req, BodyHandlers.ofString());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		sendResp=resp.body().toString();
		 } catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		 return sendResp;
    }

	

	public  String postRequestHandlerBookingIntent(String auditoriamName,String date,String fromTime,String toTime) {
    	
		 String uri=ngrokLink.getLink()+"/Alexa/bookingIntent";
			 String data1="{\"BookingObjAuditoriamName\":\""+auditoriamName+"\",\"BookingObjDate\":\""+date+
					 "\",\"BookingObjTimeFrom\":\""+fromTime+"\",\"BookingTimeTo\":\""+toTime+"\"}";
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
		HttpResponse<String> resp =client.send(req, BodyHandlers.ofString());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		sendResp=resp.body().toString();
		 } catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		 return sendResp;
    }

   
}
