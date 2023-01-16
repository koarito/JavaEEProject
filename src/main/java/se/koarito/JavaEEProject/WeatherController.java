package se.koarito.JavaEEProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

private final APIWebClient webClient;

@Autowired
    public WeatherController(APIWebClient webClient) {
        this.webClient = webClient;
    }

    //TODO: continue
/*
    @GetMapping("/weather")
    public Mono<Weather> fetchWeather(){
    Mono<Weather>
    }


 */
}
