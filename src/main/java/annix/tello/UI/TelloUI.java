package annix.tello.UI;

import annix.tello.Communication.TelloCommunication;
import annix.tello.Communication.TelloCommunicationExec;
import annix.tello.Dji.DjiTello;
import annix.tello.Dji.Tello;
import annix.tello.Exception.TelloException;
import annix.tello.command.TelloCommand;
import annix.tello.command.TelloCommandExec;
import annix.tello.command.TelloCommandValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramSocket;

public class TelloUI {

    private final JFrame frame;
    private final JButton takeOffButton,landButton, leftButton, rightButton, backwardButton, fordwardButton;
    private TelloCommunication telloCommunication;
    private TelloCommand commandStream;
    private DatagramSocket ds;
    private int Port = 11111;

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
        rightButton = new JButton("Derecha");
        controlPane.add(rightButton);
        fordwardButton = new JButton("Adelante");
        controlPane.add(fordwardButton);
        backwardButton = new JButton("Atras");
        controlPane.add(backwardButton);

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
        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tello.right(20);
            }
        });
        fordwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tello.forward(20);
            }
        });
        backwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tello.backward(20);
            }
        });

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

}
