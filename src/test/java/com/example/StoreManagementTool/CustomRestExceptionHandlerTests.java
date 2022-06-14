//package com.example.StoreManagementTool;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.apache.catalina.connector.Response;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//
//import app.exceptions.ApiError;
//
//import com.jayway.restassured.RestAssured;
//import com.jayway.restassured.response.Response;
//
//@SpringBootTest
//public class CustomRestExceptionHandlerTests {
//
//	@Test
//	public void whenMethodArgumentMismatch_thenBadRequest() {
//	    Response response = givenAuth().get(URL_PREFIX + "/api/foos/ccc");
//	    ApiError error = response.as(ApiError.class);
//
//	    assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
//	    assertEquals(1, error.getErrors().size());
//	    assertTrue(error.getErrors().get(0).contains("should be of type"));
//	}
//	
//	@Test
//	public void whenNoHandlerForHttpRequest_thenNotFound() {
//	    Response response = givenAuth().delete(URL_PREFIX + "/api/xx");
//	    ApiError error = response.as(ApiError.class);
//
//	    assertEquals(HttpStatus.NOT_FOUND, error.getStatus());
//	    assertEquals(1, error.getErrors().size());
//	    assertTrue(error.getErrors().get(0).contains("No handler found"));
//	}
//	
//	@Test
//	public void whenHttpRequestMethodNotSupported_thenMethodNotAllowed() {
//	    Response response = givenAuth().delete(URL_PREFIX + "/api/foos/1");
//	    ApiError error = response.as(ApiError.class);
//
//	    assertEquals(HttpStatus.METHOD_NOT_ALLOWED, error.getStatus());
//	    assertEquals(1, error.getErrors().size());
//	    assertTrue(error.getErrors().get(0).contains("Supported methods are"));
//	}
//	
//	@Test
//	public void whenSendInvalidHttpMediaType_thenUnsupportedMediaType() {
//	    Response response = givenAuth().body("").post(URL_PREFIX + "/api/foos");
//	    ApiError error = response.as(ApiError.class);
//
//	    assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, error.getStatus());
//	    assertEquals(1, error.getErrors().size());
//	    assertTrue(error.getErrors().get(0).contains("media type is not supported"));
//	}
//	
//	private RequestSpecification givenAuth(String username, String password) {
//	    FormAuthConfig formAuthConfig = new FormAuthConfig("http://localhost:8082/login", "username", "password");
//	    
//	    return RestAssured.given().auth().form(username, password, formAuthConfig);
//	}
//}
