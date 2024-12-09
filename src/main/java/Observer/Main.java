package Observer;

public class Main {
    public static void main(String[] args) {
        // Create the WeatherStation
        WeatherStation station = new WeatherStation();

        // Create and register observers
        WeatherObserver observer1 = new ConsoleObserver("Observer 1");
        WeatherObserver observer2 = new ConsoleObserver("Observer 2");
        WeatherObserver observer3 = new ConsoleObserver("Observer 3");

        station.registerObserver(observer1);
        station.registerObserver(observer2);
        station.registerObserver(observer3);

        // Start the WeatherStation in its own thread
        Thread stationThread = new Thread(station);
        stationThread.start();

        // Let the simulation run for 15 seconds
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Remove an observer and let the simulation run for another 10 seconds
        System.out.println("\nRemoving Observer 2...");
        station.removeObserver(observer2);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the WeatherStation
        station.stop();
        try {
            stationThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nSimulation ended.");
    }
}

