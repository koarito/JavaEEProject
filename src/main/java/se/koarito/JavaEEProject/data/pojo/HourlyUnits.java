package se.koarito.JavaEEProject.data.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HourlyUnits {
    private String time;
    private String temperature_2m;
    private String rain;

    private String windspeed_10m;
    private String winddirection_10m;


}
