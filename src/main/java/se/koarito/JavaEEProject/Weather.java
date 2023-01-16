package se.koarito.JavaEEProject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
//https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41
// &hourly=temperature_2m,rain,windspeed_10m,winddirection_10m

    private Double latitude;
    private Double longitude;
    Double generationtime_ms;

    private Integer utc_offset_seconds;

    private String timezone;
    private String timezone_abbreviation;

    private Double rain;

    private Double windspeed_10m;

    private Double winddirection_10m;

    //Nestled objects
    private HourlyUnits hourly_units;
    private Hourly hourly;



}
