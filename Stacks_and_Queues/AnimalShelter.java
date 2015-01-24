import java.util.LinkedList;

/**
 * Author: Alex Yang
 * Date: 9/13/2014
 * Dependencies:
 *  - N/A
 * Description:
 *  - Animal Shelter holds dogs and cats, and operates on a "first in first out"
 *  basis.  You must adapt either the "oldest" animal, or choose the oldest
 *  between either cat or dog.  You cannot choose the exact animal.
 *  - LIMITATION: Allowed to use built in LinkedList data structure
 *  - LIMITATION: Required to implement enqueue, dequeueAny, dequeueDog, and dequeueCat
 * Solution:
 *  - See Code.
 */

class AnimalShelter {
  public static void main(String args[]) throws Exception {
    AnimalQueue animalQueue = new AnimalQueue();

    animalQueue.enqueue(new Dog("dog1"));
    animalQueue.enqueue(new Dog("dog2"));
    animalQueue.enqueue(new Cat("cat1"));
    animalQueue.enqueue(new Cat("cat2"));
    animalQueue.enqueue(new Dog("dog3"));

    System.out.println(animalQueue.dequeueAny().getName());
    System.out.println(animalQueue.dequeueCat().getName());
    System.out.println(animalQueue.dequeueAny().getName());
    System.out.println(animalQueue.dequeueDog().getName());
  }
}

class AnimalQueue {
  LinkedList<Dog> dogs;
  LinkedList<Cat> cats;
  private int order = 0;

  public AnimalQueue() {
    this.dogs = new LinkedList<Dog>();
    this.cats = new LinkedList<Cat>();
  }

  public void enqueue(Animal animal) {
    order++;
    animal.setOrder(order);
    if (animal instanceof Dog) {
      dogs.offer((Dog)animal);
    } else {
      cats.offer((Cat)animal);
    }
  }

  public Animal dequeueAny() {
    if (dogs.peek().getOrder() <= cats.peek().getOrder()) {
      return dogs.poll();
    } else {
      return cats.poll();
    }
  }

  public Dog dequeueDog() {
    return dogs.poll();
  }

  public Cat dequeueCat() {
    return cats.poll();
  }
}

abstract class Animal {
  String name;
  private int order;
  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getOrder() {
    return this.order;
  }

  public void setOrder(int order) {
    this.order = order;
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }
}

class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }
}



