import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class hello{
    public int upp = 0;
    public int downn = 0;
    public int leftt = 0;
    public int rightt = 0;

    public hello(){

        JFrame window = new JFrame();
        window.setVisible(true);
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel up = new JLabel();
        JLabel down = new JLabel();
        JLabel left = new JLabel();
        JLabel right = new JLabel();
        panel.add(up);
        panel.add(down);
        panel.add(left);
        panel.add(right);
        up.setText("UP: "+ upp);
        down.setText("DOWN: "+ downn);
        left.setText("LEFT: "+ leftt);
        right.setText("RIGHT: "+ rightt);
        window.add(panel);
        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code){
                    case KeyEvent.VK_UP:
                        up.setText("UP: "+ (++upp));
                        break;
                    case KeyEvent.VK_DOWN:
                        down.setText("DOWN: "+ (++downn));
                        break;
                    case KeyEvent.VK_LEFT:
                        left.setText("LEFT: "+ (++leftt));
                        break;
                    case KeyEvent.VK_RIGHT:
                        right.setText("RIGHT: "+ (++rightt));
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
    public static void main(String[] args){
        new hello();
    }

}