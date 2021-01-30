package com.pvp
package lectures.part2oop

/**
  * created by praveen-vp
  */
object Generics extends App {

  class MyGenericList[A] {}
  class MyMap[key, value] {}

  val listOfIntegers = new MyGenericList[Int]
  val listOfString = new MyGenericList[String]

  // generic methods
  object MyGenericList {
    def empty[A]: MyGenericList[A] = ??? // ??? means this methods does nothing
  }

  val emptyListOfInt = MyGenericList.empty[Int];

  // variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // List of Cats extends List of Animal : known as COVARIANCE
  class CovariantList[+A] // NOTE THE '+' symbol
  val animal: Animal = new Cat
  // 1. COVARIANCE
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) is this is OK ????
  // in theory we can add a Dog to the list of
  // NO
  // 2. INVARIANCE
  // listOfCats and listOfAnimals are different
  // We can't add an animal to list of Cats
  class InvariantList[A]
  // below line throw error
  //  val invariantAnimalList : InvariantList[Animal] = new InvariantList[Cat]

  // 3 . CONTRAVARIANCE
  class ContraVariantList[-A] // NOTE '-' symbol
  // Below statement can have a valid application in other situations, but still it is a Hell No!!
  val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]
  class Trainer[-A]
  val catTrainer: Trainer[Cat] = new Trainer[Animal]

  // BOUNDED TYPES IN GENERICS
  class Cage[A <: Animal]( // means the type expected is a subtype of Animal class
      animal: A
  )

  val cage = new Cage(new Cat)
  class Car
//  val carCage = new Cage(new Car) // this line do not compile

}
