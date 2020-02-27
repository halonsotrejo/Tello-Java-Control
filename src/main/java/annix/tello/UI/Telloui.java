package annix.tello.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Telloui {

    private final JFrame frame;
    private final JButton takeOffButton,landButton;

    public Telloui(){
        /* Frame */
        frame = new JFrame("Tello");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TelloWorld telloWorld = new TelloWorldImpl();
        //telloWorld.connect();
        //telloWorld.enterCommandMode();

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

        takeOffButton = new JButton("Volar");
        controlPane.add(takeOffButton);
        landButton = new JButton("Aterrizar");
        controlPane.add(landButton);

        contentPane.add(controlPane, BorderLayout.SOUTH);


        takeOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        landButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

}
