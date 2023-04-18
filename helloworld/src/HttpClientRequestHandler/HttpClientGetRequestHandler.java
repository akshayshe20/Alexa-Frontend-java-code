package HttpClientRequestHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import ngrokLink.NgrokLink;

public class HttpClientGetRequestHandler {
		NgrokLink ngrokLink;
	  public String getRequestHandler() {
	       String respReturn="";
//		 String uri="https://656c-34-236-149-38.ngrok-free.app/Alexa/listofAuditorium";
		 String uri=ngrokLink.getLink()+"/Alexa/listofAuditorium";
				
//	    	   String uri="http://localhost:8080/admins/getAllBookings";
		 HttpRequest req=HttpRequest.newBuilder()
				 .uri(URI.create(uri))
				 .GET()
				 .version(Version.HTTP_2)
				 .build();
		 
		 HttpClient client=HttpClient.newBuilder().build();
		
		 try {
		HttpResponse<String> resp =client.send(req, BodyHandlers.ofString());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		respReturn=resp.body();
		 } catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		return respReturn;
		 
	
	    }
	  
	  public String listOfAuditorium() {
	       String respReturn="";
//		 String uri="https://656c-34-236-149-38.ngrok-free.app/Alexa/listofAuditorium";
		 String uri=ngrokLink.getLink()+"/Alexa/listofAuditorium";
				
//	    	   String uri="http://localhost:8080/admins/getAllBookings";
		 HttpRequest req=HttpRequest.newBuilder()
				 .uri(URI.create(uri))
				 .GET()
				 .version(Version.HTTP_2)
				 .build();
		 
		 HttpClient client=HttpClient.newBuilder().build();
		
		 try {
		HttpResponse<String> resp =client.send(req, BodyHandlers.ofString());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		respReturn=resp.body();
		 } catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		return respReturn;
		 
	
	    }
}
