import java.util.Stack;

public class TextEditorUndo {

    private StringBuilder text;
    private Stack<String> history;

    public TextEditorUndo() {
        text = new StringBuilder();
        history = new Stack<>();
    }

    // SAVE CURRENT STATE BEFORE EVERY CHANGE
    private void saveState() {
        history.push(text.toString());
    }

    // ADD TEXT
    public void type(String word) {
        saveState();
        text.append(word);
    }

    // DELETE LAST N CHARACTERS
    public void delete(int n) {
        if (n > text.length()) {
            n = text.length();
        }
        saveState();
        text.delete(text.length() - n, text.length());
    }

    // UNDO LAST OPERATION
    public void undo() {
        if (!history.isEmpty()) {
            text = new StringBuilder(history.pop());
        } else {
            System.out.println("NOTHING TO UNDO");
        }
    }

    // DISPLAY CURRENT TEXT
    public void show() {
        System.out.println("CURRENT TEXT: " + text.toString());
    }

    public static void main(String[] args) {
        TextEditorUndo editor = new TextEditorUndo();

        editor.type("HELLO");
        editor.show();

        editor.type(" WORLD");
        editor.show();

        editor.delete(3);
        editor.show();

        editor.undo();
        editor.show();

        editor.undo();
        editor.show();
    }
}
