//package kr.cse.gt.controller;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping("/api/android")
//public class AndroidRestController {
//
//	@RequestMapping(value = "sendGcm")
//	public String sendGcm(){
//	RestTemplate restTemplate = new RestTemplate();
//	HttpHeaders headers = new HttpHeaders();
//	headers.setContentType(MediaType.APPLICATION_JSON);
//	headers.add("Authorization","key=AIzaSyAL1pZk7PV9aPc12cTNVSC");
//	String jsonObj = "{\n" +
//	" \"to\" : \"cea8dKSFYtQ:APA91bEZDzFwHyiS8-fG3nEEcZPm90J3jHVqDA80zJrj3N9pRPXMKFbZQyCkjdsG0Xa5QbQPYMcHcT0-mb29j-IQYgFxYmhXx9ybgv4elytPxZr_HNK986qIiUFJyiCk5l3yfhJaF72s\",\n" +
//	" \"data\" : { \"message\" : \"안녕하세요\" \n" +
//	" }\n" +
//	"}"
//	;
//
//	HttpEntity request;
//	request = new HttpEntity(jsonObj, headers);
//	ResponseEntity<String> result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST,request,String.class);
//	return result.getBody();
//	}
//	
//
//
//}
