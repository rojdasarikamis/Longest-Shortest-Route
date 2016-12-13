package edu.ceng;

import java.util.List;

import static edu.ceng.TurkishNetwork.cities;
import static edu.ceng.TurkishNetwork.distance;


public class Route {

    private int routeDistance;
    private String[] routeCities;


    public Route(List<Integer> randomCities) {

        this.routeDistance = 0;
        this.routeCities = new String[randomCities.size()];

        int j = 1;

        for (int i = 0; i < randomCities.size() - 1; i++) {

            this.routeDistance += distance[randomCities.get(i)][randomCities.get(j)];
            this.routeCities[i] = cities[randomCities.get(i)];
            j++;
        }

        this.routeDistance += distance[randomCities.get(0)][randomCities.get(randomCities.size() - 1)];
        this.routeCities[randomCities.size() - 1] = cities[randomCities.get(randomCities.size() - 1)];
    }

    public int distance() {

        return this.routeDistance;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(this.distance() + "km:");

        for (String city : routeCities) {

            builder.append(city + "->");
        }

        builder.append(routeCities[0]);

        return builder.toString();
    }
}