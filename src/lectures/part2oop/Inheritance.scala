package com.pvp
package lectures.part2oop

/**
 * Created by praveen-vp on 11/29/2020
 *
 */
object Inheritance extends App {


  // Scala has single class inheritance
  class Animal {
    val animalType = "Wild"

    def eat = println("eating !!!!")

    private def privateMethod() = println("private m/d")

    protected def protectedMethod() = println("protected m/d")

    final def finalDemoMethod() = println("final method, cannot be overridden")
  }

  // a sub class can access all public, protected methods and fields from super class
  // no access modifier means public
  class Cat extends Animal

  val cat = new Cat
  cat.eat

  // inheritance a class with fields in the constructor
  class Person(name: String, age: Int) {

    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, id: Int) extends Person(name, age)

  class Child(name: String) extends Person(name)

  // JVM instantiate new class, first it will be instantiating the super class, ie first call the
  // subclass will be the super class constructor
  // so we need to specify which constructor need to be called while instantiating the sub class


  // OVER RIDING A METHOD
  class Dog extends Animal {

    // field overriding
    override val animalType: String = "domestic"

    // overriding the method
    override def eat = println("overriding eat method!!!")
  }

  val dog = new Dog
  dog.eat
  println(dog.animalType)

  // overriding the fields in the constructor
  class Duck(override val animalType: String) extends Animal {

  }

  val duck = new Duck("domestic and bird")

  // the value passed in the constructor overrides the field value with the value passed in the
  // constructor
  // equivalent to
  class Bird(animal: String) extends Animal {
    override val animalType = animal
  }

  val bird = new Bird("Duck !!!")
  println(bird.animalType)


  // Type substitution
  val unknown: Animal = new Dog
  unknown.eat // will call the eat method overridden in the Dog class

  // super
  // if the sub class need to call a method from the super class, sub class will use super
  // keyword to mention the method in the super class

  // preventing the overriding
  // 1. use final keyword in the members --> cannot override the method 'finalDemoMethod()' in
  // the sub classes
  // 2. use final keyword in the class, prevents from deriving a sub class
  // 3. "sealed" when used the sealed keyword in the class it prevents the use of the classes in
  // the other files, the scope of the class is limited to that particular file

}
