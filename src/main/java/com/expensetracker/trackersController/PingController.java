package com.expensetracker.trackersController;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pingService")
public class PingController {
	
	@GetMapping("/ping")
	public String pingWorking() {
		
		JSONObject jObj = new JSONObject();
		try {
			jObj.put("Ping", "Test");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jObj.toString();
	}
}
