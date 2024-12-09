package Memento;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> undoStack = new Stack<>();
    private final Stack<Memento> redoStack = new Stack<>();

    public void saveState(Memento memento) {
        undoStack.push(memento);
        redoStack.clear(); // Clear redo stack on new changes
    }

    public Memento undo(Memento currentState) {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            return undoStack.pop();
        }
        return currentState; // No undo available
    }

    public Memento redo(Memento currentState) {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            return redoStack.pop();
        }
        return currentState; // No redo available
    }

    public Stack<Memento> getHistory() {
        return (Stack<Memento>) undoStack.clone(); // Return a clone for immutability
    }
}

