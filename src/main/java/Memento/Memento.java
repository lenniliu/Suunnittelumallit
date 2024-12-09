package Memento;

import java.time.LocalDateTime;

public class Memento {
    private final String color1;
    private final String color2;
    private final String color3;
    private final boolean checkboxState;
    private final LocalDateTime timestamp;

    public Memento(String color1, String color2, String color3, boolean checkboxState) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.checkboxState = checkboxState;
        this.timestamp = LocalDateTime.now();
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public String getColor3() {
        return color3;
    }

    public boolean isCheckboxState() {
        return checkboxState;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("State saved at %s | Colors: [%s, %s, %s], Checkbox: %s",
                timestamp, color1, color2, color3, checkboxState ? "Checked" : "Unchecked");
    }
}

