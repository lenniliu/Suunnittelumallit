package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class WeatherStation implements Runnable {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private boolean running = true;

    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;
    private final Random random = new Random();

    public WeatherStation() {
        // Set an initial random temperature
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        // Change the temperature by -1, 0, or +1 within bounds
        int change = random.nextInt(3) - 1;
        temperature += change;
        if (temperature < MIN_TEMP) {
            temperature = MIN_TEMP;
        } else if (temperature > MAX_TEMP) {
            temperature = MAX_TEMP;
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                // Simulate a delay (1-5 seconds)
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            updateTemperature();
            notifyObservers();
        }
    }

    public void stop() {
        running = false;
    }
}

