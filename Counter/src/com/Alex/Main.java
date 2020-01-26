package com.Alex;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java program with graphical interface which simulates a timer (using threads of execution).
 * It has two buttons, one for starting and continuing the sequence of time
 * and the other for returning to the initial position.
 */

public class Main{
    static JTextField text;

    public static JTextField getTextField() {return text;}
    public static void main(String[] args) {
        Main ex4 = new Main();
        JFrame frame= new JFrame();
        Timer timer = new Timer();
        ex4.init(frame, timer);
    }

    public void init(JFrame frame, Timer timer) {

        GridBagConstraints c = new GridBagConstraints();
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        text = new JTextField("00:00:00");
        text.setFont(new Font("SansSerif",Font.BOLD,25));
        text.setEditable(false);
        text.setFocusable(false);
        text.setBorder(new LineBorder(Color.gray,1));

        start.setFocusable(false);
        start.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized(timer.lock) {
                    try {
                        if(timer.getState() == Thread.State.NEW)
                            timer.start();
                        else timer.lock.notifyAll();
                        timer.paused=false;
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }
            }
        });

        stop.setFocusable(false);
        stop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.paused=true;
            }

        });

        frame.setLayout(new GridBagLayout());
        frame.setSize(200,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.fill = GridBagConstraints.HORIZONTAL;

        frame.add(text);
        c.gridx=0;
        c.gridy=1;
        frame.add(start,c);
        c.gridy=2;
        frame.add(stop,c);
    }
}

class Timer extends Thread {
    private int ms=0, m=0,s=0;
    Object lock = new Object();
    volatile boolean paused = true;

    @Override
    public void run() {
        for(;;ms++) {
            try {
                synchronized(lock) {
                    while(paused) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if(ms>=500) {ms=0; s++;}
                if(s==60) {s=0; m++;}
                Main.getTextField().setText((m < 10 ? "0" : "")+m+":"+(s < 10 ? "0" : "")+s+":"+(ms<100 ? (ms<10 ? "0" : "")+ms : ms/10));
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
