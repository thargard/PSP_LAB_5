package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FIOReg extends JFrame {
    DefaultListModel<String> data1 = new DefaultListModel<String>();
    DefaultListModel<String> data2 = new DefaultListModel<String>();
    DefaultListModel<String> data3 = new DefaultListModel<String>();
    static JLabel l1, l2, l3, l4;
    static JTextField text;
    JList<String> surname, firstname, lastname;
    JButton add, del;
    public FIOReg(String str){
        super(str);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add = new JButton("Добавить");
        del = new JButton("Очистить поле");

        add.addActionListener(new AddActionListener());
        del.addActionListener(new DelActionListener());

        text = new JTextField(9);

        l1 = new JLabel("ФИО");
        l2 = new JLabel("Фамилия");
        l3 = new JLabel("Имя");
        l4 = new JLabel("Отчество");

        surname = new JList<String>(data1);
        firstname = new JList<String>(data2);
        lastname = new JList<String>(data3);

        setLayout(null);
        add.setSize(90, 30);
        add.setLocation(250, 20);
        del.setSize(130, 30);
        del.setLocation(350, 20);
        text.setSize(170, 30);
        text.setLocation(70, 20);
        l1.setSize(40, 30);
        l1.setLocation(10, 20);

        l2.setSize(150, 30);
        l2.setLocation(10, 60);
        l3.setSize(150, 30);
        l3.setLocation(170, 60);
        l4.setSize(150, 30);
        l4.setLocation(330, 60);

        surname.setSize(150, 350);
        surname.setLocation(10, 100);
        firstname.setSize(150, 350);
        firstname.setLocation(170,100);
        lastname.setSize(150, 350);
        lastname.setLocation(330, 100);

        add(add);
        add(del);
        add(text);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(surname);
        add(firstname);
        add(lastname);
    }

    public class AddActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String[] fio = text.getText().split(" ");
            data1.addElement(fio[0]);
            data2.addElement(fio[1]);
            data3.addElement(fio[2]);
            if(data1.size() >= 10){
                add.setEnabled(false);
                JDialog dialog = new JDialog(FIOReg.this, "Ошибка", false);
                dialog.setSize(400, 120);
                JButton closeButton = new JButton("Больше нельзя добавлять! Лимит 10 человек! Закрыть");
                closeButton.setSize(60, 40);
                closeButton.setLocation(80, 60);
                dialog.add(closeButton);
                closeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });
                dialog.setVisible(true);
            }
        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            text.setText(null);
        }
    }
}
