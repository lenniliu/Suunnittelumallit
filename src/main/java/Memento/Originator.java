package Memento;

public class Originator {
    private String color1;
    private String color2;
    private String color3;
    private boolean checkboxState;

    public Memento saveStateToMemento() {
        return new Memento(color1, color2, color3, checkboxState);
    }

    public void restoreStateFromMemento(Memento memento) {
        this.color1 = memento.getColor1();
        this.color2 = memento.getColor2();
        this.color3 = memento.getColor3();
        this.checkboxState = memento.isCheckboxState();
    }

    // Getters and setters for the state
    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public boolean isCheckboxState() {
        return checkboxState;
    }

    public void setCheckboxState(boolean checkboxState) {
        this.checkboxState = checkboxState;
    }
}

