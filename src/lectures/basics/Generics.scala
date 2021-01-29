package com.pvp
package lectures.basics

/**
 * Created by praveen-vp on 12/3/2020
 *
 */
object Generics extends App {

  // generic type representation in square brackets
  class MyList[+A] {

    def add[B >: A](element: B): MyList[B] = ???

    // A - Animal
    // B - Cat
    // the new list will return type B
  }

  // declare a class with 2 type parameters
  class MyMap[key, value]

  val intList = new MyList[Int]
  val stringList = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // Questions
  // if Cat extends Animal does a List of Cat also extends List of Animal
  // three possible answers
  // 1. YES
  // List[Cat] extends List[Animal] called "COVARIANCE"
  // Covariance list declaration
  class CovarianceList[+A]

  // variable instantiation,
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]

  // Question 2 : Can I add a Dog to the animalList declared above ?
  // above animalList is a list of animals, in theory we can add an animal to it. But the list is
  // actually a list of Cat, if we add a Dog to it, it will pollute the list.
  // it is a hard question!!!!!

  // ans : NO, called "INVARIANT" List
  // declared as normal list
  class InvariantList[A]

  // invariant classes are each in its own world, we cannot substitute one for other
  val invariantListOfAnimal: InvariantList[Animal] = new InvariantList[Animal]

  // below declaration throws error
  //val invariantListOfAnimal : InvariantList[Animal] = new InvariantList[Cat]

  // ans : Hell, no !
  // CONTRAVARIANCE
  class ContraVariantList[-A]

  val contraVariantListCat: ContraVariantList[Dog] = new ContraVariantList[Animal]

  // the above declaration is too bad, as Animal can be anything.
  // lets check below scenario
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // An Animal trainer can also train Cat !!!

  // BOUNDED Types
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car

  //val carCage = new Cage(new Car) // this will not compile, as the Car is not a sub class of Animal

}
