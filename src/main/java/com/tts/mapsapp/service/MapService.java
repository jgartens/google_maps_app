package com.tts.mapsapp.service;

import java.util.Random;

import com.tts.mapsapp.models.GeocodingResponse;
import com.tts.mapsapp.models.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {

	@Value("${api_key}")
	private String apiKey;

	public boolean addCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + ","
				+ location.getState() + "&key=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        
        if (!response.getResults().isEmpty()) {
            Location coordinates = response.getResults().get(0).getGeometry().getLocation();
            location.setLat(coordinates.getLat());
            location.setLng(coordinates.getLng());
            return true;
        }

        else{
            return false;
        }
	}

   
	public Location getRandomCoordinates() {
        Random r = new Random();
        double randLong = -180 + (180 + 180) * r.nextDouble();
        double randLat = -90 + (90 + 90) * r.nextDouble();
        
        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + randLat + "," + randLong 
        + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location location = response.getResults().get(0).getGeometry().getLocation();
        return location;
	}

}