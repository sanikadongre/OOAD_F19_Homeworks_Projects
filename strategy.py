# -*- coding: utf-8 -*-
"""
Created on Tue Oct  1 20:37:41 2019

@author: shrut
"""

import sys
from abc import ABC, abstractmethod
import random

class NoiseBehavior:
    def __init__(self, name=" "):
        self.name = name 
    def makeNoise(self):
        pass

class LionNoise(NoiseBehavior):
    def makeNoise(self):
        print(self.name + " Lion makes noise LionGrrr.")  
        
class CatNoise(NoiseBehavior):        
    def makeNoise(self):
      #use random number generation to select from alternative responses to animal actions
        if(random.randint(1,101) < 50): 
            #Math.random() generates number between 0 & 1
            print(self.name + " Cat makes noise Meow.")
        else:
            print(self.name + " Cat makes noise Meowwww and Meowwww.")
            
class ElephantNoise(NoiseBehavior):
    def makeNoise(self):
        super().makeNoise()
        print(self.name + " Elephant makes noise Mooooo.")

class HippoNoise(NoiseBehavior):
    def makeNoise(self):
        super().makeNoise()
        print(self.name + " Hippo makes noise Hipooo.")

class RhinoNoise(NoiseBehavior):
    def makeNoise(self):
        super().makeNoise()
        print(self.name + " Rhino makes noise Rhinooo.")

class TigerNoise(NoiseBehavior):
     def makeNoise(self):
        super().makeNoise()
        print(self.name + " Tiger makes noise Tigrrrrr.")

class WolfNoise(NoiseBehavior):
    def makeNoise(self):
        super().makeNoise()
        print(self.name + " Wolf makes noise Grrrrr.")

class DogNoise(NoiseBehavior):
     def makeNoise(self):
        super().makeNoise()
        print(self.name + " Dog makes noise Woof.")
    
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

    def __init__(self,name,cat_noise):
        self.cat_noise = cat_noise
        self.name = name

    def makeNoise(self):
        self.cat_noise.makeNoise()

    def roam(self):
        #use random number generation to select from alternative responses to animal actions
        if(random.randint(1,101) < 50):
      #Math.random() generates number between 0 & 1
            print(self.name + " Cat exercises by stretching and licking itself.")
        else:
            print(self.name + " Cat exercises by playing with itself and purring.")
            
class Elephant(Pachyderm):
    def __init__(self,name,elephant_noise):
        self.elephant_noise = elephant_noise
        self.name = name

    def makeNoise(self):
        self.elephant_noise.makeNoise()

    def roam(self):
        print(self.name + " Elephant exercises by moving and bathing in the muddy water.")


class Hippo(Pachyderm):

    def __init__(self,name,hippo_noise):
        self.hippo_noise = hippo_noise
        self.name = name
    def makeNoise(self):
        self.hippo_noise.makeNoise()

    def roam(self):
        print(self.name + " Hippo exercises by jumping up and down in the water.")

class Lion(Feline):

    def __init__(self,name,lion_noise):
        self.lion_noise = lion_noise
        self.name = name

    def makeNoise(self):
        self.lion_noise.makeNoise()
        
    def roam(self):
        print(self.name + " Lion exercises by running quick and putting claws in trees.")

class Rhino(Pachyderm):

    def __init__(self,name,rhino_noise):
        self.rhino_noise = rhino_noise
        self.name = name
    
    def makeNoise(self):
        self.rhino_noise.makeNoise()

    def roam(self):
        print(self.name + " Rhino exercises by jumping up and down in the grass.")


class Tiger(Feline):
    
    def __init__(self,name,tiger_noise):
        self.tiger_noise = tiger_noise
        self.name = name
    
    def makeNoise(self):
        self.tiger_noise.makeNoise()

    def roam(self):
        print(self.name + " Tiger exercises by running quick and putting claws in trees.")


class Wolf(Canine):
    
    def __init__(self,name,wolf_noise):
        self.wolf_noise = wolf_noise
        self.name = name
    
    def makeNoise(self):
        self.wolf_noise.makeNoise()
    def roam(self):
        print(self.name + " Wolf exercises by stretching and licking itself.")


class Dog(Canine):

    def __init__(self,name,dog_noise):
        self.dog_noise = dog_noise
        self.name = name
    def makeNoise(self):
        self.dog_noise.makeNoise()
   
    def roam(self):
        print(self.name + " Dog exercises by stretching and sprinting.")

    
class ZooKeeper:
    
    
      
    def __init__(self):
        sys.stdout = open('dayatthezoo_strategy.txt','wt')
        print("----- Day At the Zoo: Output -----")
        print("Zoo Opened.")
        print("")
        animals=[Animal()]
        animals.append(Cat("Cheshire",CatNoise("Cheshire")))
        animals.append(Cat("Cuddles",CatNoise("Cuddles")))
        animals.append(Lion("Leo",LionNoise("Leo")))
        animals.append(Lion("Lewis",LionNoise("Lewis")))
        animals.append(Tiger("Tigran",TigerNoise("Tigran")))
        animals.append(Tiger("Tigru",TigerNoise("Tigru")))
        animals.append(Elephant("Ellen",ElephantNoise("Ellen")))
        animals.append(Elephant("Elson",ElephantNoise("Elson")))
        animals.append(Dog("Deo",DogNoise("Deo")))
        animals.append(Dog("Dawn",DogNoise("Dawn")))
        animals.append(Hippo("Hank",HippoNoise("Hank")))
        animals.append(Hippo("Hustler",HippoNoise("Hustler")))
        animals.append(Rhino("Rincon",RhinoNoise("Rincon")))
        animals.append(Rhino("Ruben",RhinoNoise("Ruben")))
        animals.append(Tiger("Truben",TigerNoise("Truben")))
        animals.append(Wolf("Will",WolfNoise("Will")))
        animals.append(Wolf("Wiz",WolfNoise("Wiz")))
        self.performTasksSequentially(animals)
        print("")
        print("Zoo Closed")


    #def createZooAnimals(self):
        
            
    def performTasksSequentially(self,animals):
        print("----------- wakeUpAnimals --------------")
        self.performFunction("wakeUpAnimals",animals)
        print("----------- rollCallAnimals --------------")
        self.performFunction("rollCallAnimals",animals)
        print("----------- feedAnimals --------------")
        self.performFunction("feedAnimals",animals)
        print("------------ exerciseAnimals -------------")
        self.performFunction("exerciseAnimals",animals)
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


