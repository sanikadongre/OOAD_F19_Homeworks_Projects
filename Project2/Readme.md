Project Group:

1. Sanika Dongre

2. Shruthi Sridharan 

3. Preethi Vijai Lilly 

1a -
The implementation focusses on the Zookeeper using basic OOAD inheritance mechanism. The program uses three levels of Inheritance: Top level base class: Animal - is the parent class Mid level: Feline, Canine, Pachyderm- extends Animal Concrete implementations for Animals at the third level - overrides the methods in above two classes. Animal class is the topmost level (base class) class will be inherited by child classes - All the properties and methods inherited across all the child classes.

1b- 

Zookeeper with Strategy pattern:

We abstract the NoiseBehavior characteristic or feature out from the Animal Interface. This allows the program to choose at runtime depending on the animal type and its specific behavior. Thus, at the object creation of specific animals, the instance of NoiseBehavior is passed on.

1c- 

A new class ZooAnnouncer is created which acts as the observer. It responds to change in events of the subject ZooKeeper class. ZooAnnouncer has updateAnnouncer function which assigns the value and calls announce_event(). This function prints the event update for each of the zookeeper actions. The animal list is created with different animal names. Zookeeper performs tasks sequentially for which the announcer updates and announces the event. After the sleep function, zoo announcer deconstructs which is shown in removeObs function.
