
import com.example.FIOReg;
import com.example.SecondPart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("FIO - 1 часть, что-то другое это 2 часть!");
        String line = scanner.nextLine();

        if (line == "FIO"){
            FIOReg app = new FIOReg("Списки фамилий");
            app.setVisible(true);
            app.setResizable(false);
            app.setLocationRelativeTo(null);
        } else {
            SecondPart sp = new SecondPart("Салон красоты");
            sp.setVisible(true);
            sp.setResizable(false);
            sp.setLocationRelativeTo(null);
        }
    }
}