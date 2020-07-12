package com.spring.gateway.springgatewayexample;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	    		  .route(p -> p
	                        .path("/all")
	                        .filters(f ->
	                                f.addRequestHeader("x-rapidapi-host", "nanosdk-countries-v1.p.rapidapi.com")
	                                        .addRequestHeader("x-rapidapi-key", "c732499affmshf48ef8d5e3c6dfap1f4c12jsna61f4a717fd3")
	                                        .hystrix(config -> config.setName("countries-service")
	                                                /*.setFallbackUri("forward:/countriesfallback")*/)
	                        )
	                        .uri("https://restcountries-v1.p.rapidapi.com")
	                )
	                .route(p -> p
	                        .path("/v1/joke")
	                        .filters(f ->
	                                f.addRequestHeader("x-rapidapi-host", "joke3.p.rapidapi.com")
	                                        .addRequestHeader("x-rapidapi-key", "c732499affmshf48ef8d5e3c6dfap1f4c12jsna61f4a717fd3")
	                                        .hystrix(config -> config.setName("joke-service")
	                                                .setFallbackUri("forward:/jokefallback"))
	                        )
	                        .uri("https://joke3.p.rapidapi.com")
	                )
	                
	    		
	    	/*.route(p -> p
	            .path("/get")
	            .filters(f -> f.addRequestHeader("Hello", "Worlds"))
	            .uri("http://httpbin.org:80"))
	        .route(p -> p
	            .host("*.hystrix.com")
	            .filters(f -> f.hystrix(config -> config.setName("mycmd")))
	            .uri("http://httpbin.org:80"))*/
	        .build();
	}
}
