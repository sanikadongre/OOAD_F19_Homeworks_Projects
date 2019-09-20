Project Group: 

1) Sanika Dongre
2) Shruthi Sridharan (added as collaborator: shruthi1111)
3) Preethi Vijai Lilly (added as collaborator: PreethiVijai

The program uses three levels of inheritance: 
Top level base class: Animal.java - is an abstract class
Mid level: Feline, Canine, Pachyderm - extends Animal 
Concrete implementations for Animals at the third level - Overrides the methods in above two classes. 

Zookeeper has main method. Zookeeper instantiates all animals and executes the tasks in sequential manner: 
Ex: Zookeeper first opens zoo, wakes all animals, roll calls, feeds, exercises them and then shuts the zoo. 

The animals respond to these actions. Polymorphism in Java comes into play as specific methods are invoked, for each animal. 
Some methods are invoked from Animal class (like wake up, sleep, etc.)
Some methods are overridden in child classes: ex: roam, that print specific responses to actions.

Random number generator used in Cat class: 
Based on Math.random(), the responses are printed for both - roam() and makeNoise() methods. 

Final output: 
Running Zookeeper.java- the output is generated in file: dayatthezoo.txt in the project folder itself
