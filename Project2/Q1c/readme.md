A new class ZooAnnouncer is created which acts as the observer. It responds to change in events of the subject ZooKeeper class. ZooAnnouncer has updateAnnouncer function which assigns the value and calls announce_event(). This function prints the event update for each of the zookeeper actions. The animal list is created with different animal names. Zookeeper performs tasks sequentially for which the announcer updates and announces the event. After the sleep function, zoo announcer deconstructs which is shown in removeObs function.

FILE TO BE RUN: zoo_observer.py

OUTPUT FILE: dayatthezoo_observer.txt
