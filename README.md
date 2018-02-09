# Very Basic City Simulation
For this project, I was responsible for designing a system that would simulate drivers moving between roads within Pittsburgh.  The simulation was not complex, and in fact is very simple.  The driver can move between four roads via predetermined intersections.  When a driver exits the city, which is only possible on two of the four roads, the simulation determines whether the driver is moving to Philadelphia, or to Cleveland. It is possible to provide a seed to the simulation, which allows the runs of the program to be reproduced.  

This project was the second assignment for my Software Quality Assurance class at the University of Pittsburgh.  The project emphasized Unit Testing as a development tool.  This was my first real exposure to the process of Unit Testing, and I feel as though it has made me a significantly better developer, as I am thinking about edge cases AND testing them as I write my code.  While the scope of this project was not very large, it was still an interesting and valuable experience.  

## Usage
Compile  
`javac CitySim9005.java`  

Run  
`java CitySim9005 <integer>`

Example Output:  
```
> java CitySim9005 10
Driver 1 heading from Hotel to Diner via Fourth Ave.
Driver 1 heading from Diner to Outside City via Fourth Ave.
Driver 1 has gone to Philadelphia!
-----
Driver 2 heading from Coffee to Library via Fifth Ave.
Driver 2 heading from Library to Hotel via Bill St.
Driver 2 heading from Hotel to Diner via Fourth Ave.
Driver 2 heading from Diner to Outside City via Fourth Ave.
Driver 2 has gone to Philadelphia!
-----
Driver 3 heading from Diner to Outside City via Fourth Ave.
Driver 3 has gone to Philadelphia!
-----
Driver 4 heading from Coffee to Diner via Phil St.
Driver 4 heading from Diner to Coffee via Phil St.
Driver 4 heading from Coffee to Diner via Phil St.
Driver 4 heading from Diner to Coffee via Phil St.
Driver 4 heading from Coffee to Library via Fifth Ave.
Driver 4 heading from Library to Outside City via Fifth Ave.
Driver 4 has gone to Cleveland!
-----
Driver 5 heading from Coffee to Diner via Phil St.
Driver 5 heading from Diner to Outside City via Fourth Ave.
Driver 5 has gone to Philadelphia!
-----
```

Compile for Testing:  
`javac -cp ./junit-4.12.jar:./hamcrest-core-1.3.jar:./mockito-core-1.10.19.jar:./objenesis-2.4.jar *.java`  

Run Tests:  
`java -cp .:./junit-4.12.jar:./hamcrest-core-1.3.jar:./mockito-core-1.10.19.jar:./objenesis-2.4.jar TestRunner`

## Author: John Dott  
Created for Software Quality Assurance (CS 1632)
