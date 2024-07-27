import java.util.List;
import java.util.ArrayList;

interface WeatherData {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}


interface Observer {
    void update(float temperature, float humidity, float pressure);
}


class WeatherStation implements WeatherData {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

class DisplayUnit implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees, " + humidity + "% humidity, and " + pressure + " pressure.");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        DisplayUnit display1 = new DisplayUnit();
        DisplayUnit display2 = new DisplayUnit();

        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        weatherStation.setMeasurements(80, 65, 30.4f);
        weatherStation.setMeasurements(82, 70, 29.2f);
    }
}
