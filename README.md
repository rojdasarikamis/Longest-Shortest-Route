# Longest/Shortest Route
Longest/Shortest Route


The `TurkishNetwork.java` file includes travel distances (in kilometers) between 81 cities in Turkey.

The starter code generates all possible combination of C(81,*n*) cities from the 81 cities of Turkey using the [combinatorics](https://github.com/dpaukov/combinatoricslib3) library. 
Given a list of *n* cities, suppose you are going to visit each city exactly once in the order of the list. And you will return to the first city.
You are asked to find the shortest or the longest possible route for a given *n*.

For example,

* mvn clean package
* java -jar target/HW2-1.0.jar -n 6 -p longest 

Will print out something like:

```
11146km:EDİRNE->HAKKARİ->KIRKLARELİ->SİİRT->TEKİRDAĞ->VAN->EDİRNE
```

* java -jar target/HW2-1.0.jar -n 6 -p shortest 

Will print out something like:

```
682km:BOLU->KOCAELİ->SAKARYA->ZONGULDAK->BARTIN->KARABÜK->BOLU
```

The starter code contains the skeleton of the project and some test cases. 
You will need to:

* Implement the `Route` class and add it to the source tree.
* Modify the `Main.java` file to make things compile and tests pass.

At the end, all of the tests in `TestMain` should pass. (i.e, `mvn clean test` passes)
To parse command line arguments please use [args4j](https://github.com/kohsuke/args4j/blob/master/args4j-maven-plugin-example/src/main/java/org/kohsuke/args4j/maven/Example.java) which already inluded in the pom.xml file.

* Do not modify `findLongest` or `findShortest` methods
* Do not modify the `TestMain.java` file
* Do not modify the `pom.xml` file