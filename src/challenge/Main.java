package challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, AstronomicalEntity> solarSystem = new HashMap<>();
    private static Set<Planet> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet planet = new Planet("Mercury", 88);
        planets.add(planet);

        planet = new Planet("Venus", 225);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new Planet("Earth", 365);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        Moon planetMoon = new Moon("Moon", 27);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addSatellite(planetMoon);

        planet = new Planet("Mars", 687);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planetMoon = new Moon("Deimos", 1.3);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Mars

        planetMoon = new Moon("Phobos", 0.3);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Mars

        planet = new Planet("Jupiter", 4332);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planetMoon = new Moon("Io", 1.8);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planetMoon = new Moon("Europa", 3.5);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planetMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planetMoon = new Moon("Callisto", 16.7);
        solarSystem.put(planetMoon.getName(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planet = new Planet("Saturn", 10759);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new Planet("Uranus", 30660);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new Planet("Neptune", 165);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planet = new Planet("Pluto", 248);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        planets.forEach(entry -> System.out.println(entry)); // will use toString()

    }
}
