package ua.com.alevel.service;

import java.util.Scanner;

public class PlanetReporter {

    public static void printInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер планеты");
        System.out.println("Меркурий - 1");
        System.out.println("Венера - 2");
        System.out.println("Земля - 3");
        System.out.println("Марс - 4");
        System.out.println("Сатурн - 5");
        System.out.println("Юпитер - 6");
        System.out.println("Уран - 7");
        System.out.println("Нептун - 8");
        String z = scanner.nextLine();
        if (z.equals("1")) {
            Mercury planet = new Mercury();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else if (z.equals("2")) {
            Venus planet = new Venus();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else if (z.equals("3")) {
            Earth planet = new Earth();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else if (z.equals("4")) {
            Mars planet = new Mars();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else if (z.equals("5")) {
            Saturn planet = new Saturn();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else if (z.equals("6")) {
            Jupiter planet = new Jupiter();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else if (z.equals("7")) {
            Uranus planet = new Uranus();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else if (z.equals("8")) {
            Neptune planet = new Neptune();
            System.out.println(planet.calculateAccelerationOfGravity());
        }
        else {
            System.out.println("Вы ввели неверное число!");
            printInfo();
        }
    }
}
