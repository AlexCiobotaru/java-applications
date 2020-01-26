

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventarView extends JFrame{

    JTextField jtfName;
    JTextField jtfQuantity;
    JTextField jtfPrice;
    JTextArea  jtfList;
    JLabel     jtlName;
    JLabel     jtlQuantity;
    JLabel     jtlPrice;
    JButton    actionNew;
    JButton    actionView;
    JButton    actionChange;
    JButton    actionDelete;

    ArrayList<Inventar> storage = new ArrayList<Inventar>();


    InventarView(){

        this.setLayout(new FlowLayout());

        jtfName       = new JTextField(20);
        jtfQuantity   = new JTextField(20);
        jtfPrice      = new JTextField(20);
        jtfList       = new JTextArea(5,60);
        jtlName       = new JLabel("Name");
        jtlQuantity   = new JLabel("Quantity");
        jtlPrice      = new JLabel("Price");
        actionNew     = new JButton("New");
        actionView    = new JButton("View");
        actionChange  = new JButton("Change");
        actionDelete  = new JButton("Delete");

        Panel pnlone = new Panel();
        pnlone.add(jtlName);
        pnlone.add(jtlQuantity);
        pnlone.add(jtlPrice);

        Panel pnltwo = new Panel();
        pnltwo.add(jtfName);
        pnltwo.add(jtfQuantity);
        pnltwo.add(jtfPrice);

        Panel pnlfour = new Panel();
        pnlfour.add(actionNew);
        pnlfour.add(actionView);
        pnlfour.add(actionChange);
        pnlfour.add(actionDelete);

        Panel pnlthree = new Panel();
        pnlthree.add(jtfList);

        pnlone.setBackground(Color.gray);
        pnltwo.setBackground(Color.green);
        pnlthree.setBackground(Color.blue);
        pnlfour.setBackground(Color.yellow);

        add(pnlone);
        add(pnltwo);
        add(pnlfour);
        add(pnlthree);

        actionNew.addActionListener(new NewListener());
        actionView.addActionListener(new ViewListener());
        actionChange.addActionListener(new ChangeListener());
        actionDelete.addActionListener(new DeleteListener());


    }

    class NewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Inventar aux=new Inventar();
            int    q=0;
            float  p=0;
            String userInputn="";
            String userInputq="";
            String userInputp="";
            try {
                userInputn=jtfName.getText();
            }catch(NumberFormatException nfex) {
                JOptionPane.showMessageDialog(InventarView.this,
                        "Bad input: '" + userInputn + "'");
            }
            try {
                userInputq=jtfQuantity.getText();
                q=Integer.parseInt(userInputq);
            }catch(NumberFormatException nfex) {
                JOptionPane.showMessageDialog(InventarView.this,
                        "Bad input: '" + userInputq + "'");
            }
            try {
                userInputp=jtfPrice.getText();
                p=Float.parseFloat(userInputp);
            }catch(NumberFormatException nfex) {
                JOptionPane.showMessageDialog(InventarView.this,
                        "Bad input: '" + userInputp + "'");
            }

            jtfName.setText("");
            jtfQuantity.setText("");
            jtfPrice.setText("");

            aux.setName(userInputn);
            aux.setQuantity(q);
            aux.setPrice(p);
            storage.add(aux);

        }

    }
    class ViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfList.setText("");
            for(int i=0;i<storage.size();i++) {
                jtfList.append("["+storage.get(i).getName()+" ; "+storage.get(i).getQuantity()+";"+storage.get(i).getPrice()+"] ");
            }
        }

    }
    class ChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String auxn="";
            int    auxqn = 0;

            try {
                auxn=jtfName.getText();
            }catch(NumberFormatException nfex) {
                JOptionPane.showMessageDialog(InventarView.this,
                        "Bad input: '" + auxn + "'");
            }
            try {
                auxqn=Integer.parseInt(jtfQuantity.getText());

            }catch(NumberFormatException nfex) {
                JOptionPane.showMessageDialog(InventarView.this,
                        "Bad input: '" + auxqn + "'");
            }
            for(int i = 0;i<storage.size();i++) {
                if(storage.get(i).getName().equals(auxn)) {
                    storage.get(i).setQuantity(auxqn);
                }
            }

            jtfName.setText("");
            jtfQuantity.setText("");
            jtfPrice.setText("");



        }

    }
    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String aux="";

            try {
                aux=jtfName.getText();
            }catch(NumberFormatException nfex) {
                JOptionPane.showMessageDialog(InventarView.this,
                        "Bad input: '" + aux + "'");
            }
            for(int i = 0;i<storage.size();i++) {
                if(storage.get(i).getName().equals(aux)) {
                    storage.remove(i);
                }
            }



            jtfName.setText("");
            jtfQuantity.setText("");
            jtfPrice.setText("");

        }

    }

}
