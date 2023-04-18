/*
 * package com.bookmycon.webClientService;
 * 
 * import org.springframework.web.reactive.function.client.WebClient;
 * 
 * import com.bookmycon.model.User;
 * 
 * import reactor.core.publisher.Flux;
 * 
 * public class WebClientService {
 * 
 * private final WebClient webClient;
 * 
 * public WebClientService(WebClient.Builder webClientBuilder) {
 * this.webClient=webClientBuilder.baseUrl("http://localhost:8080/user").build()
 * ; } public Flux<User> findBooking(){ System.out.println(
 * this.webClient.get().uri("/allUser").retrieve().bodyToFlux(User.class));
 * return
 * this.webClient.get().uri("/allUser").retrieve().bodyToFlux(User.class); } }
 */