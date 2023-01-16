package se.koarito.JavaEEProject;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Hourly {

    public ArrayList<String> time;
    public ArrayList<Double> temperature_2m;
    public ArrayList<Double> rain;

}
