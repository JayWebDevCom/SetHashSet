package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, AstronomicalEntity> solarSystem = new HashMap<>();
    private static Set<AstronomicalEntity> planets = new HashSet<>();

    public static void main(String[] args) {
	    AstronomicalEntity temp = new AstronomicalEntity("Mercury", 88);
	    solarSystem.put(temp.getName(), temp);
	    planets.add(temp);

        temp = new AstronomicalEntity("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new AstronomicalEntity("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        AstronomicalEntity tempMoon = new AstronomicalEntity("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        planets.add(tempMoon);
        temp.addMoon(tempMoon);

        temp = new AstronomicalEntity("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new AstronomicalEntity("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new AstronomicalEntity("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new AstronomicalEntity("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new AstronomicalEntity("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new AstronomicalEntity("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new AstronomicalEntity("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new AstronomicalEntity("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new AstronomicalEntity("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new AstronomicalEntity("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new AstronomicalEntity("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new AstronomicalEntity("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets...");

        for (AstronomicalEntity planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        AstronomicalEntity body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for (AstronomicalEntity moon : body.getSatellites()) {
            System.out.println("\t" + moon.getName());
        }

        Set<AstronomicalEntity> allMoons = new HashSet<>();

        for (AstronomicalEntity planet : planets) {
            allMoons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons from all planets...");
        for (AstronomicalEntity moon : allMoons) {
            System.out.println("\t" + moon.getName()); // no duplicates
        }

        AstronomicalEntity pluto = new AstronomicalEntity("Pluto", 248);
        AstronomicalEntity pluto2 = new AstronomicalEntity("Pluto", 248);
        System.out.println(pluto.equals(pluto2));
        System.out.println();

        pluto2 = new AstronomicalEntity("Plutooooo", 842);
        System.out.println(pluto.equals(pluto2)); // same because we are comparing by name

    }
}
