package kr.cse.gt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.cse.gt.model.AndroidToken;
import kr.cse.gt.service.AndroidTokenService;

@RestController
@RequestMapping("/api/android")
public class AndroidRestController {

	@Autowired
	private AndroidTokenService androidTokenService;	

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public String takeToken(@RequestParam(value = "token") String token, HttpServletRequest request) {

		System.out.println("token: " + token);

		AndroidToken androidToken = new AndroidToken();
		androidToken.setToken(token);
		androidTokenService.saveAndFlush(androidToken);

		return null;

	}

}
