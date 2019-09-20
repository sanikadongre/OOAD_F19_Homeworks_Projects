Project Group: 

1) Sanika Dongre
2) Shruthi Sridharan (added as collaborator: Shruthi1111)
3) Preethi Vijai Lilly (added as collaborator: PreethiVijai)

The program uses three levels of inheritance: 
Top level base class: Animal.java - is an abstract class
Mid level: Feline, Canine, Pachyderm - extends Animal 
Concrete implementations for Animals at the third level - Overrides the methods in above two classes. 
Animal class is the topmost level (base class) abstract class that will  be inherited by child classes - All the properties and methods inherited across all the child classes.

Zookeeper has main method. Zookeeper instantiates all animals and executes the tasks in sequential manner: 
Ex: Zookeeper first opens zoo, wakes all animals, roll calls, feeds, exercises them and then shuts the zoo. 

The animals respond to these actions. Polymorphism in Java comes into play as specific methods are invoked, for each animal. 
Some methods are invoked from Animal class (like wake up, sleep, etc.)
Some methods are overridden in child classes: ex: roam, that print specific responses to actions.
The Wake and sleep functions can be generic hence there is no need to override. This demonstrates calling a base class method from the inherting class instance. The eat, makenoise and roam methods will be overriden - some are overriden in the second level of inheritance/ others in third level of specific animal type classes. 

Random number generator used in Cat class: 
Based on Math.random(), the responses are printed for both - roam() and makeNoise() methods. 

Final output: 
Running Zookeeper.java- the output is generated in file: dayatthezoo.txt in the project folder itself
