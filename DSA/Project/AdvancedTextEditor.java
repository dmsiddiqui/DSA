package Project;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Stack;
public class AdvancedTextEditor {
    private Stack<String> undoStack;
    private JTextArea textArea;
    private JFrame frame;
    private JLabel statusBar;

    public AdvancedTextEditor() {
        undoStack = new Stack<>();
        setupGUI();
    }
    private void setupGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Could not set look and feel: " + e.getMessage());
        }

        frame = new JFrame("Advanced Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Text area with scroll pane
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Status bar
        statusBar = new JLabel("Words: 0 | Characters: 0");
        statusBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(statusBar, BorderLayout.SOUTH);

        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                updateStatusBar();
            }
        });

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem printFile = new JMenuItem("Print");
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(printFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        newFile.addActionListener(e -> newText());
        openFile.addActionListener(e -> openFile());
        saveFile.addActionListener(e -> saveToFile());
        printFile.addActionListener(e -> printText());
        exit.addActionListener(e -> frame.dispose());

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem findReplace = new JMenuItem("Find & Replace");

        undo.addActionListener(e -> undo());
        findReplace.addActionListener(e -> findAndReplace());

        editMenu.add(undo);
        editMenu.add(findReplace);

        // Format menu
        JMenu formatMenu = new JMenu("Format");
        JMenuItem changeFont = new JMenuItem("Change Font");

        changeFont.addActionListener(e -> changeFontStyle());
        formatMenu.add(changeFont);

        // View menu
        JMenu viewMenu = new JMenu("View");
        JMenuItem toggleDarkMode = new JMenuItem("Toggle Dark Mode");

        toggleDarkMode.addActionListener(e -> toggleDarkMode());
        viewMenu.add(toggleDarkMode);

        // Adding menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);

        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    private void updateStatusBar() {
        String text = textArea.getText();
        int words = text.isBlank() ? 0 : text.split("\\s+").length;
        int characters = text.length();
        statusBar.setText("Words: " + words + " | Characters: " + characters);
    }
    private void newText() {
        undoStack.push(textArea.getText());
        textArea.setText("");
        updateStatusBar();
    }

    private void undo() {
        if (!undoStack.isEmpty()) {
            textArea.setText(undoStack.pop());
            updateStatusBar();
        } else {
            JOptionPane.showMessageDialog(frame, "Nothing to undo!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void findAndReplace() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel findLabel = new JLabel("Find:");
        JTextField findField = new JTextField();
        JLabel replaceLabel = new JLabel("Replace with:");
        JTextField replaceField = new JTextField();

        panel.add(findLabel);
        panel.add(findField);
        panel.add(replaceLabel);
        panel.add(replaceField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Find & Replace", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String findText = findField.getText();
            String replaceText = replaceField.getText();
            String content = textArea.getText();

            if (content.contains(findText)) {
                content = content.replace(findText, replaceText);
                textArea.setText(content);
                JOptionPane.showMessageDialog(frame, "Text replaced successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Text not found!");
            }
        }
    }
    private void changeFontStyle() {
        Font currentFont = textArea.getFont();
        String fontName = JOptionPane.showInputDialog(frame, "Enter Font Name (e.g., Monospaced, Serif):", currentFont.getFamily());
        if (fontName != null && !fontName.isEmpty()) {
            int fontSize = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Font Size:", currentFont.getSize()));
            textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));
        }
    }

    private void toggleDarkMode() {
        Color bgColor = textArea.getBackground().equals(Color.WHITE) ? Color.DARK_GRAY : Color.WHITE;
        Color fgColor = textArea.getForeground().equals(Color.BLACK) ? Color.WHITE : Color.BLACK;
        textArea.setBackground(bgColor);
        textArea.setForeground(fgColor);
    }
    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(frame, "File saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                undoStack.push(textArea.getText());
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                updateStatusBar();
                JOptionPane.showMessageDialog(frame, "File opened successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error opening file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void printText() {
        try {
            boolean printed = textArea.print();
            if (printed) {
                JOptionPane.showMessageDialog(frame, "Print successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Print canceled!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error printing: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdvancedTextEditor::new);
    }
}
