package com.Alex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tic Tac Toe game.
 * The application provides a user interface (build using AWT and SWING technologies) that allows 2 players to play the game.
 * The app also implements ActionEvents and ActionListeners in order to react to mouse events.
 */

public class Game extends JFrame {

    JButton buttons[] = new JButton[9];
    int player=0;

    public Game(){
        setTitle("Tic Tac Toe Game");
        setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++) {
            buttons[i]=new JButton("Empty");
            buttons[i].addActionListener(new ActionPress());
            add(buttons[i]);
        }

        setVisible(true);
        setSize(500,300);
    }
    public void resetButtons(){
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("Empty");
        }
    }
    public boolean linecheckstate(int a,int b,int c) {
        if(buttons[a].getText().equals(buttons[b].getText()) && buttons[a].getText().equals(buttons[c].getText()))
        {
            if(!buttons[b].getText().equals("Empty") && !buttons[c].getText().equals("Empty"))
            {
                return true;
            }
        }
        return false;

    }
    public boolean fullcheckstate() {
        for(int i=0;i<=8;i++) {
            if(buttons[i].getText().equals("Empty")) {
                return false;
            }
        }
        return true;
    }

    public boolean checkstatemap(){

        if(linecheckstate(0,1,2))
            return true;
        else if(linecheckstate(3,4,5))
            return true;
        else if(linecheckstate(6,7,8))
            return true;

        if(linecheckstate(0,3,6))
            return true;
        else if(linecheckstate(1,4,7))
            return true;
        else if(linecheckstate(2,5,8))
            return true;

        if(linecheckstate(0,4,8))
            return true;
        else if(linecheckstate(2,4,6))
            return true;
        else
            return false;
    }

    private class ActionPress implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            player++;
            JButton buttonClicked = (JButton)e.getSource();

            if(player%2 == 0) {
                if((buttonClicked.getText()!="X")&&(buttonClicked.getText()!="O")) {
                    buttonClicked.setText("O");}
            }else {
                if((buttonClicked.getText()!="X")&&(buttonClicked.getText()!="O")) {
                    buttonClicked.setText("X");}
            }
            if(checkstatemap()==true) {
                if(player%2==0) {
                    JOptionPane.showMessageDialog(null, "We have a winner!!! O won");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "We have a winner!!! X won");
                }
                resetButtons();
            }
            if(fullcheckstate()) {
                JOptionPane.showMessageDialog(null, "Full");
                resetButtons();
            }
        }
    }
}
