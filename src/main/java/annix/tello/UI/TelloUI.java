package annix.tello.UI;

import annix.tello.Dji.DjiTello;
import annix.tello.Dji.Tello;
import annix.tello.Exception.TelloException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelloUI {

    private final JFrame frame;
    private final JButton takeOffButton,landButton, leftButton;

    public TelloUI() throws TelloException {
        /* Frame */
        frame = new JFrame("Tello");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tello tello = new DjiTello();
        tello.connect();
        tello.enterCommandMode();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //mediaPlayerComponent.release();
                System.exit(0);
            }
        });
        /* Panel */
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel videoPane = new JPanel();
        contentPane.add(videoPane,BorderLayout.CENTER);

        JPanel controlPane = new JPanel();
        controlPane.setBackground(Color.BLACK);

        takeOffButton = new JButton("Despegar");
        controlPane.add(takeOffButton);
        landButton = new JButton("Aterrizar");
        controlPane.add(landButton);
        leftButton = new JButton("Izquierda");
        controlPane.add(leftButton);

        contentPane.add(controlPane, BorderLayout.SOUTH);

        takeOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tello.takeOff();
            }
        });
        landButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tello.land();
            }
        });
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tello.left(20);
            }
        });

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

}
