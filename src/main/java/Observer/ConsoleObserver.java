package Observer;

class ConsoleObserver implements WeatherObserver {
    private String name;

    public ConsoleObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " received update: Current temperature is " + temperature + "°C");
    }
}

