import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class KeyboardMouseEventDemo extends JFrame implements KeyListener, MouseListener {
    JLabel messageLabel;
    KeyboardMouseEventDemo() {
        setTitle("Keyboard and Mouse Event Demo");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        messageLabel = new JLabel("Press a key or click the mouse inside the window.");
        add(messageLabel);
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setVisible(true);
    }
    public void keyPressed(KeyEvent e) {
        messageLabel.setText("Key Pressed: " + e.getKeyChar());
    }
    public void keyReleased(KeyEvent e) {
        messageLabel.setText("Key Released: " + e.getKeyChar());
    }
    public void keyTyped(KeyEvent e) {
        messageLabel.setText("Key Typed: " + e.getKeyChar());
    }

    public void mouseClicked(MouseEvent e) {
        messageLabel.setText("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mousePressed(MouseEvent e) {
        messageLabel.setText("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseReleased(MouseEvent e) {
        messageLabel.setText("Mouse Released at (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseEntered(MouseEvent e) {
        messageLabel.setText("Mouse Entered the window");
    }
    public void mouseExited(MouseEvent e) {
        messageLabel.setText("Mouse Exited the window");
    }
    public static void main(String[] args) {
        new KeyboardMouseEventDemo();
    }
}