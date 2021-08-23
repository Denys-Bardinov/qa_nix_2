package ua.com.alevel;

import ua.com.alevel.service.Planet;
import ua.com.alevel.service.PlanetReporter;
import ua.com.alevel.service.Mercury;

public class Main {
    public static void main(String[] args) {
        Planet planet = new Mercury();
        PlanetReporter.printInfo();
    }
}
