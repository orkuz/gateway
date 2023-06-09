package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

// tag::code[]
@SpringBootApplication
@EnableConfigurationProperties()
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// // tag::route-locator[]
	// @Bean
	// public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
	// 	String httpUri = uriConfiguration.getHttpbin();
	// 	return builder.routes()
	// 		.route(p -> p
	// 			.path("/get")
	// 			.filters(f -> f.addRequestHeader("Hello", "World"))
	// 			.uri(httpUri))
	// 		.route(p -> p
	// 			.host("*.circuitbreaker.com")
	// 			.filters(f -> f
	// 				.circuitBreaker(config -> config
	// 					.setName("mycmd")
	// 					.setFallbackUri("forward:/fallback")))
	// 			.uri(httpUri))
	// 		.build();
	// }
	// // end::route-locator[]

	// // tag::fallback[]
	// @RequestMapping("/fallback")
	// public Mono<String> fallback() {
	// 	return Mono.just("fallback");
	// }
	// // end::fallback[]
}

// // tag::uri-configuration[]
// @ConfigurationProperties
// class UriConfiguration {
	
// 	private String httpbin = "http://httpbin.org:80";

// 	public String getHttpbin() {
// 		return httpbin;
// 	}

// 	public void setHttpbin(String httpbin) {
// 		this.httpbin = httpbin;
// 	}
// }
// // end::uri-configuration[]
// // end::code[]