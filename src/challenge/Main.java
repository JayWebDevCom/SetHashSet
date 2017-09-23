package challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<AstronomicalEntity.Key, AstronomicalEntity> solarSystem = new HashMap<>();
    private static Set<AstronomicalEntity> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet planet = new Planet("Mercury", 88);
        planets.add(planet);

        planet = new Planet("Venus", 225);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        planet = new Planet("Earth", 365);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        Moon planetMoon = new Moon("Moon", 27);
        solarSystem.put(planetMoon.getKey(), planetMoon);
        planet.addSatellite(planetMoon);

        planet = new Planet("Mars", 687);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        planetMoon = new Moon("Deimos", 1.3);
        solarSystem.put(planetMoon.getKey(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Mars

        planetMoon = new Moon("Phobos", 0.3);
        solarSystem.put(planetMoon.getKey(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Mars

        planet = new Planet("Jupiter", 4332);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        planetMoon = new Moon("Io", 1.8);
        solarSystem.put(planetMoon.getKey(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planetMoon = new Moon("Europa", 3.5);
        solarSystem.put(planetMoon.getKey(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planetMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(planetMoon.getKey(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planetMoon = new Moon("Callisto", 16.7);
        solarSystem.put(planetMoon.getKey(), planetMoon);
        planet.addSatellite(planetMoon); // planet is still Jupiter

        planet = new Planet("Saturn", 10759);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        planet = new Planet("Uranus", 30660);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        planet = new Planet("Neptune", 165);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);

        AstronomicalEntity myPlanet = new Planet("Pluto", 248);
        solarSystem.put(myPlanet.getKey(), myPlanet);
        planets.add(myPlanet);

        AstronomicalEntity mydPlanet = new Planet("Pluto", 842);
        solarSystem.put(mydPlanet.getKey(), mydPlanet);
        planets.add(mydPlanet);

        planets.forEach(entry -> System.out.println(entry));
        // will use toString()
        // Pluto appears twice - once as planet once as dwarf planet

        AstronomicalEntity earthOne = new Planet("Earth", 365);
        AstronomicalEntity earthTwo = new Planet("Earth", 365);

        // Symmetric similarity
        System.out.println(earthOne.equals(earthTwo) && earthTwo.equals(earthOne));
        System.out.println();

        AstronomicalEntity ae = solarSystem.get(AstronomicalEntity.makeKey("Mars", AstronomicalEntity.BodyType.PLANET));
        System.out.println("Moons of " + ae.getName());
        ae.getSatellites().forEach(entry -> {
            System.out.print(entry.getName() + " ");
        });
        System.out.println();
        System.out.println();

        solarSystem.put(planet.getKey(), planet);
        System.out.println(
                solarSystem.get(
                        AstronomicalEntity.makeKey(
                                    mydPlanet.getName(),
                                    AstronomicalEntity.BodyType.PLANET
                                                    )
                                )
                        );
        System.out.println(
                solarSystem.get(
                        AstronomicalEntity.makeKey(
                                mydPlanet.getName(),
                                AstronomicalEntity.BodyType.DWARF_PLANET
                        )
                )
        ); // returns null because same planet cannot be added twice because of checking
        //  in overridden equals() of bodytype

        System.out.println();


        System.out.println("Solar System Contains: ");
        solarSystem.values().forEach(so -> {
            System.out.print(so.getName() + " ");
        });


        System.out.println();
        System.out.println();
        String[] allSolarSystem = planets.stream()
                .map(AstronomicalEntity::getName)
                .toArray(String[]::new);

        System.out.println("All Planets: " + String.join(", ", allSolarSystem) + "");


    }
}
