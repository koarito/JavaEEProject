package se.koarito.JavaEEProject.data.pojo;

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




    //Nestled objects
    private HourlyUnits hourly_units;
    private Hourly hourly;



}
