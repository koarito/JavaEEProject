package se.koarito.JavaEEProject;

import org.springframework.stereotype.Service;
 import org.springframework.web.reactive.function.client.WebClient;
@Service
public class APIWebClient {

  WebClient webClient = WebClient.create("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,rain,windspeed_10m,winddirection_10m");
}
