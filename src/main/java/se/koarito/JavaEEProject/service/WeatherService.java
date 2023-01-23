package se.koarito.JavaEEProject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.koarito.JavaEEProject.data.pojo.Weather;

@Service
public class WeatherService {

 public Weather callWeatherApi(Double latitude, Double longitude){
 final String url = "https://api.open-meteo.com/v1/forecast?latitude="+latitude.toString()+"&longitude="+longitude.toString()+"&current_weather=true&temperature_2m,rain,windspeed_10m";
 RestTemplate restTemplate = new RestTemplate();
 Weather weather;

  try {
   weather = restTemplate.getForObject(url, Weather.class);
   return weather;
  }catch (Exception e){
   e.printStackTrace();
  }
  return null;
 }
}
