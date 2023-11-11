package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class SecondPart extends JFrame {
    File file = new File("C://temp//PSPLAB5.txt");
    int k;
    static JLabel lb1, lb2, lb3, lb4;
    JButton signUp, showUsers, exit;
    JRadioButton flag1, flag2;
    ButtonGroup bg;
    JTextField fio, age;
    JTextArea createdUsers;
    public SecondPart(String str){
        super(str);
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fio = new JTextField(9);
        age = new JTextField(9);
        createdUsers = new JTextArea(9,9);
        lb1 = new JLabel("ФИО:");
        lb2 = new JLabel("Возраст:");
        lb3 = new JLabel("Пол:");
        lb4 = new JLabel("Список посетителей:");
        signUp = new JButton("Зарегать");
        showUsers = new JButton("Показать посетителей");
        exit = new JButton("Выйти");
        flag1 = new JRadioButton("Мужчина");
        flag2 = new JRadioButton("Женщина");
        bg = new ButtonGroup();
        bg.add(flag1);
        bg.add(flag2);

        setLayout(null);
        fio.setSize(300, 30);
        fio.setLocation(80, 10);
        age.setSize(300, 30);
        age.setLocation(80, 50);
        createdUsers.setSize(300, 100);
        createdUsers.setLocation(100, 200);
        lb1.setSize(40, 30);
        lb1.setLocation(10, 10);
        lb2.setSize(60, 30);
        lb2.setLocation(10, 50);
        lb3.setSize(40, 30);
        lb3.setLocation(10, 100);
        lb4.setSize(140, 30);
        lb4.setLocation(10, 140);
        signUp.setSize(100, 30);
        signUp.setLocation(310, 100);
        showUsers.setSize(200, 30);
        showUsers.setLocation(150, 320);
        exit.setSize(100, 30);
        exit.setLocation(200, 360);
        flag1.setSize(90, 30);
        flag1.setLocation(70, 100);
        flag2.setSize(90, 30);
        flag2.setLocation(170, 100);

        add(fio);
        add(age);
        add(createdUsers);
        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(signUp);
        add(flag1);
        add(flag2);
        add(showUsers);
        add(exit);

        signUp.addActionListener(new SignUpActionListener());
        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());
        showUsers.addActionListener(new ShowUsersActionListtener());
        exit.addActionListener(new ExitActionListener());
    }

    public class SignUpActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);
                try{
                    String userFio = fio.getText();
                    String userAge = age.getText();
                    out.write(userFio + ", ");
                    out.write(userAge + " лет, ");
                    if(k == 1){
                        out.write("Мужчина\n");
                    } else {
                        out.write("Женщина\n");
                    }
                } finally {
                    out.close();
                }
            } catch (IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

    public class FlagActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            k = 0;
            if (e.getSource() == flag1){
                k++;
            } else if (e.getSource() == flag2){
                k--;
            }
        }
    }

    public class ShowUsersActionListtener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try{
                FileReader fr = new FileReader(file);
                Scanner scanner = new Scanner(fr);

                String line = "";
                while(scanner.hasNextLine()){
                    line += scanner.nextLine() + "\n";
                }
                fr.close();

                String[] users = line.split("\n");
                String[] usersFio = new String[users.length];
                for (int i = 0; i < users.length; i++) {
                    usersFio[i] += users[i].split(", ")[0];
                }

                String res = "";
                for (String str: usersFio){
                    res += str.replaceAll("null", "") + "\n";
                }
                createdUsers.setText(res);
            }catch (IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

    public class ExitActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            exit(0);
        }
    }
}
