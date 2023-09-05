package main.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.externalapi.model.myip.MyIP;
import main.externalapi.model.openweathermap.OpenWeatherMap;

@Service
public class ExternalAPIsServiceImpl implements ExternalAPIsService{

	private static final String OPENWEATHERMAP_API_KEY = "3fed025a9763fc70c0560e4f66b4c767";
	
	private static final String OPENWEATHERMAP_ADDRESS = "http://api.openweathermap.org/data/2.5/";
	
	private static final String IPAPI_ADDRESS = "https://ipapi.co/";
	
	private static final String MYIP_ADDRESS = "https://api.myip.com";
	
	private static final String LOCALHOST_IP_V4 = "127.0.0.1";
	
	private static final String LOCALHOST_IP_V6 = "0:0:0:0:0:0:0:1";
	
	
	
	@Override
	public OpenWeatherMap getData(HttpServletRequest request) {
		
		// get ip
		String ip = getIpAddress(request);
		
		// get city
		String city = getCity(ip);
		
		// get weather object
		OpenWeatherMap openWeatherMap = getWeatherForCity(city);
		
		return openWeatherMap;
	}
	
	private String getIpAddress(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		if(ip.equals(LOCALHOST_IP_V4) || ip.equals(LOCALHOST_IP_V6)) {
			RestTemplate restTemplate = new RestTemplate(); 
			String result = restTemplate.getForObject(MYIP_ADDRESS, String.class);
			ObjectMapper mapper = new ObjectMapper();
			MyIP myIP = new MyIP();
			try {
				myIP = mapper.readValue(result, MyIP.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			ip = myIP.getIp();
		}
		return ip;
	}
	
	private String getCity(String ip) {
		RestTemplate restTemplate = new RestTemplate();
		String city = restTemplate.getForObject(IPAPI_ADDRESS + ip + "/city", String.class);
		return city;
	}
	
	private OpenWeatherMap getWeatherForCity(String city) {
		StringBuilder url = new StringBuilder();
		url.append(OPENWEATHERMAP_ADDRESS);
		url.append("weather?q=").append(city).append("&units=metric").append("&appid=").append(OPENWEATHERMAP_API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		OpenWeatherMap openWeatherMap = new OpenWeatherMap();
		try {
			String response = restTemplate.getForObject(url.toString(),String.class);
			ObjectMapper mapper = new ObjectMapper();
			openWeatherMap = mapper.readValue(response, OpenWeatherMap.class);
		} catch (JsonProcessingException | HttpClientErrorException e) {
			return null;
		}
		return openWeatherMap;
	}

}
