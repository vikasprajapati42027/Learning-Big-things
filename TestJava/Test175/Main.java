package TestJava.Test175;

import java.util.ArrayList;
import java.util.List;

// 1. Memento (The Object storing the checkpoint state)
class EditorMemento {
    private final String content;

    public EditorMemento(String content) { 
        this.content = content; 
    }
    public String getSavedContent() { return content; }
}

// 2. Originator (The Object being saved/restored)
class TextEditor {
    private String content = "";

    public void type(String words) { content += words; }
    public String getContent() { return content; }

    // Save state to a Memento!
    public EditorMemento save() {
        return new EditorMemento(content);
    }

    // Restore state from a Memento!
    public void restore(EditorMemento memento) {
        this.content = memento.getSavedContent();
    }
}

// 3. Caretaker (Manages the history of Mementos)
class HistoryManager {
    private final List<EditorMemento> history = new ArrayList<>();

    public void push(EditorMemento memento) { history.add(memento); }
    
    public EditorMemento pop() {
        if (history.isEmpty()) return null;
        int lastIndex = history.size() - 1;
        EditorMemento lastState = history.get(lastIndex);
        history.remove(lastIndex);
        return lastState;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 175: Memento Pattern (Undo/Redo) ===\n");

        System.out.println("Captures and externalizes an object's internal state so it can be restored later,");
        System.out.println("like saving a checkpoint in a video game or CTRL+Z in a text editor!\n");

        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        editor.type("Hello ");
        System.out.println("Current text: " + editor.getContent());
        
        // Save Checkpoint 1
        history.push(editor.save());
        
        editor.type("World! ");
        System.out.println("Current text: " + editor.getContent());
        
        // Save Checkpoint 2
        history.push(editor.save());
        
        editor.type("Oh wait, this is a typo.");
        System.out.println("Current text: " + editor.getContent());
        
        // CTRL + Z !
        System.out.println("\nUser pressed CTRL+Z...");
        editor.restore(history.pop());
        System.out.println("Current text: " + editor.getContent());
        
        // CTRL + Z again!
        System.out.println("User pressed CTRL+Z again...");
        editor.restore(history.pop());
        System.out.println("Current text: " + editor.getContent());
    }
}
