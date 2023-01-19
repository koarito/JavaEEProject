package se.koarito.JavaEEProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import se.koarito.JavaEEProject.data.pojo.Weather;
import se.koarito.JavaEEProject.service.WeatherService;

@RestController
@CrossOrigin
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/info")
    Weather getWeatherInfo(@RequestParam Double latitude, @RequestParam Double longitude){
        return weatherService.callWeatherApi(latitude, longitude);
    }
}
