package lab8;
import java.util.LinkedList;
import java.util.Scanner;

public class UndoRedoProgram {
    private LinkedList<String> undoStack;
    private LinkedList<String> redoStack;

    public UndoRedoProgram() {
        undoStack = new LinkedList<>();
        redoStack = new LinkedList<>();
    }

    public void insert(String value) {
        undoStack.push(value);
        redoStack.clear(); // Clear redo stack on new insert
    }

    public String undo() {
        if (!undoStack.isEmpty()) {
            String item = undoStack.pop();
            redoStack.push(item);
            return "Undo successful";
        } else {
            return "Stack is empty";
        }
    }

    public String redo() {
        if (!redoStack.isEmpty()) {
            String item = redoStack.pop();
            undoStack.push(item);
            return "Redo successful";
        } else {
            return "Redo unsuccessful";
        }
    }

    public void displayStack() {
        // Display the contents of the undo stack
        System.out.println("Current Stack (Undo): " + undoStack);
    }

    public static void main(String[] args) {
        UndoRedoProgram program = new UndoRedoProgram();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Please enter your choice: (1 for insert, 2 for undo, 3 for redo, 4 for display stack, 0 to exit)");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Input: ");
                    String input = scanner.nextLine();
                    program.insert(input);
                    break;
                case 2:
                    System.out.println(program.undo());
                    break;
                case 3:
                    System.out.println(program.redo());
                    break;
                case 4:
                    program.displayStack();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

