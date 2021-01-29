package com.pvp
package lectures.part2oop

/**
 * Created by praveen-vp on 11/30/2020
 *
 */
object AbstractDataTypes extends App {

  //////////////////////
  // abstract classes///
  //////////////////////
  // instance of an abstract class cannot be instantiated
  abstract class Animal {
    val creatorType: String

    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatorType: String = "Domestic" // the override keyword is not mandatory in the
    // implementations classes
    // val creatorType: String = "Domestic"

    override def eat(): Unit = println("Dog is eating !!!!") // override not mandatory
    // def eat(): Unit = println("Dog is eating !!!!")
  }

  ////////////////
  //// Traits ////
  ////////////////

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait WaterLife

  class Crocodile extends Animal with Carnivore with WaterLife {
    override val creatorType: String = "Carnivore"

    override def eat(): Unit = println("no food available !!!!")

    override def eat(animal: Animal): Unit = println(s"I'm eating a ${animal.creatorType} dog")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat()
  croc.eat(dog)

  // A class can inherit one class and one class can extend multiple traits, kind of interfaces
  // in java

  /////////////////////////
  // Traits  vs Abstract //
  /////////////////////////
  // 1. Traits do not have a constructor parameter
  // 2. multiple traits can be inherited
  // 3. traits are behaviours and but abstracts are a thing

  // POINTS TO REMEMBER
  //  Scala.Any
  //  Scala.AnyRef
  //  Scala.Null
  //  Scala.Nothing
  //  Scala.AnyVal


}
