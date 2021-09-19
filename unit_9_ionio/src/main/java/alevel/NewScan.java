package alevel;

import java.util.Scanner;

public class NewScan {
    public String scannerString;
    public String returnScan() {
        Scanner scanner = new Scanner(System.in);
    this.scannerString = scanner.nextLine();
    return scannerString;
    }
}
