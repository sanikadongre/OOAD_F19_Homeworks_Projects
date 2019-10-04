#Reference link:
#https://refactoring.guru/design-patterns/observer/python/example

import sys
from abc import ABC, abstractmethod
import random

class ZooAnnouncer():

    def __init__(self, zk):
        self.zk =zk
        self.zk.registerObs(self)
        self.value = None
    
    def updateAnnouncer(self,value):
        self.value = value
        self.announce_event()
        
    def announce_event(self):
        print("\nHi! This is Zoo Announcer. Zookeeper is going to {} the animals\n".format(self.value))

        
class Animal():
    def __init__(self, name=" "):
        
        self.name = name
    
    def wakeUp(self):
        if self.name != " ":
            print(self.name," The animal wakes up.")    

    def sleep(self):
        if self.name != " ":
            print(self.name + " The animal sleeps.")

    def eat(self):
        if self.name != " ":
            print(self.name + " The animal eats.")

    @abstractmethod
    def roam(self):
        pass
    @abstractmethod
    def makeNoise(self):
        pass
    

class Canine(Animal):


    def eat(self):
        print(self.name + " The Canine animal eats meat.")

    def roam(self):
        super().roam()
        print(self.name + " The Canine animal roams in pack.")


class Feline(Animal):


    def eat(self):
        print(self.name + " The Feline animal eats raw meat.")


    def roam(self):
        super().roam()
        print(self.name + " The Feline animal roams individually/alone.")


class Pachyderm(Animal):

    def eat(self):
        print(self.name + " The Pachyderm animal eats grass and/or some meat.")


    def roam(self):
        super().roam()
        print(self.name + " The Pachyderm animal roams in herds or by itself.")

class Cat(Feline):

    def __init__(self,name):
        self.name = name;

    def makeNoise(self):
        super().makeNoise()
      #use random number generation to select from alternative responses to animal actions
        if(random.randint(1,101) < 50): 
            #Math.random() generates number between 0 & 1
            print(self.name + " Cat makes noise Meow.")
        else:
            print(self.name + " Cat makes noise Meowwww and Meowwww.")

    def roam(self):
        #use random number generation to select from alternative responses to animal actions
        if(random.randint(1,101) < 50):
      #Math.random() generates number between 0 & 1
            print(self.name + " Cat exercises by stretching and licking itself.")
        else:
            print(self.name + " Cat exercises by playing with itself and purring.")
            
class Elephant(Pachyderm):
    def __init__(self,name):
        self.name = name;

    def makeNoise(self):
        super().makeNoise()
        print(self.name + " Elephant makes noise Mooooo.")


    def roam(self):
        print(self.name + " Elephant exercises by moving and bathing in the muddy water.")


class Hippo(Pachyderm):

    def __init__(self,name):
        self.name = name

    def makeNoise(self):
        super().makeNoise()
        print(self.name + " Hippo makes noise Hipooo.")
    def roam(self):
        print(self.name + " Hippo exercises by jumping up and down in the water.")

class Lion(Feline):

    def __init__(self,name):
        self.name = name

    def makeNoise(self):
        super().makeNoise()
        print(self.name + " Lion makes noise LionGrrr.")

    def roam(self):
        print(self.name + " Lion exercises by running quick and putting claws in trees.")

class Rhino(Pachyderm):

    def __init__(self,name):
        self.name = name
    
    def makeNoise(self):
        super().makeNoise()
        print(self.name + "Rhino makes noise Rhinooo.")

    def roam(self):
        print(self.name + " Rhino exercises by jumping up and down in the grass.")


class Tiger(Feline):
    
    def __init__(self,name):
        self.name = name
    
    def makeNoise(self):
        super().makeNoise()
        print(self.name + "Tiger makes noise Tigrrrrr.")

    def roam(self):
        print(self.name + "Tiger exercises by running quick and putting claws in trees.")


class Wolf(Canine):
    
    def __init__(self,name):
        self.name = name
    
    def makeNoise(self):
        super().makeNoise()
        print(self.name + "Wolf makes noise Grrrrr.")

    def roam(self):
        print(self.name + "Wolf exercises by stretching and licking itself.")


class Dog(Canine):

    def __init__(self,name):
        self.name = name
    
    def makeNoise(self):
        super().makeNoise()
        print(self.name + "Dog makes noise Woof.")

    def roam(self):
        print(self.name + "Dog exercises by stretching and sprinting.")

    
class ZooKeeper:
    
      
    def __init__(self):
        self.value = None
        self.observers= []
        sys.stdout = open('dayatthezoo_observer.txt','wt')
        
        za=ZooAnnouncer(self)
        print("----- Day At the Zoo: Output -----")
        print("Zoo Opened.")
        print("")

    
        animals=[Animal()]
        animals.append(Cat("Cheshire"))
        animals.append(Cat("Cuddles"))
        animals.append(Lion("Leo"))
        animals.append(Lion("Lewis"))
        animals.append(Tiger("Tigran"))
        animals.append(Tiger("Tigru"))
        animals.append(Elephant("Ellen"))
        animals.append(Elephant("Elson"))
        animals.append(Dog("Deo"))
        animals.append(Dog("Dawn"))
        animals.append(Hippo("Hank"))
        animals.append(Hippo("Hustler"))
        animals.append(Rhino("Rincon"))
        animals.append(Rhino("Ruben"))
        animals.append(Tiger("Ruben"))
        animals.append(Wolf("Will"))
        animals.append(Wolf("Wiz"))
        self.performTasksSequentially(animals) 
        print("")
        print("Zoo Closed")
        self.removeObs(za)

    def setValue(self,value):
        self.value=value
        self.notifyObs()
        
    def registerObs(self, observer):
        self.observers.append(observer)
    
    def removeObs(self, observer):
        print("Zoo Announcer signing off! Have a good day")
        self.observers.remove(observer)
        
    def notifyObs(self):
        for observer in self.observers:
            observer.updateAnnouncer(self.value)
            
    def performTasksSequentially(self,animals):
        self.setValue("wake")
        print("----------- wakeUpAnimals --------------")
        self.performFunction("wakeUpAnimals",animals)
        self.setValue("roll call")
        print("----------- rollCallAnimals --------------")
        self.performFunction("rollCallAnimals",animals)
        self.setValue("feed")
        print("----------- feedAnimals --------------")
        self.performFunction("feedAnimals",animals)
        self.setValue("exercise")
        print("------------ exerciseAnimals -------------")
        self.performFunction("exerciseAnimals",animals)
        self.setValue("sleep")
        print("------------ shutDownZoo -------------")
        self.performFunction("shutDownZoo",animals)

    def one(self,a):
        return  a.wakeUp()
 
    def two(self,a):
        return  a.makeNoise();
 
    def three(self,a):
        return a.eat();
 
    def four(self,a):
        return  a.roam();
 
    def five(self,a):
        return a.sleep();

    
    def performFunction(self,Task,animals):
        for a in animals:
            if Task == "wakeUpAnimals":
                self.one(a)
            elif Task == "rollCallAnimals":
                self.two(a)
            elif Task == "feedAnimals":
                self.three(a)
            elif Task == "exerciseAnimals":
                self.four(a)
            elif Task == "shutDownZoo":
                self.five(a)

    

if __name__ == '__main__':
    zk=ZooKeeper() 
    


