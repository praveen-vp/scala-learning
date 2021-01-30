package com.pvp
package experiments

/**
  * created by praveen-vp on 22-Jan-2021
  */
abstract class GenericList[+A] {
  /*
   * head  -- first element of the list
   * tail -- remainder of the list
   * isEmpty -- is this is empty
   * add(int) -- add element to the list and return a new list
   * toString -- string representation of the list.
   */
  def head: A
  def tail: GenericList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericList[B]
  def printElement: String
  override def toString: String = "[" + printElement + "]"
}

object EmptyList extends GenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: GenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GenericList[B] =
    new GCons(element, EmptyList)
  def printElement: String = ""
}

class GCons[+A](h: A, t: GenericList[A]) extends GenericList[A] {
  def head: A = h
  def tail: GenericList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): GenericList[B] = new GCons(element, this)

  def printElement: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElement
  }
}

object ListTest extends App {
  val listOfIntegers: GenericList[Int] =
    new GCons[Int](1, new GCons[Int](2, new GCons[Int](3, EmptyList)))

  println(listOfIntegers.toString)

  val listOfStrings: GenericList[String] =
    new GCons[String]("Hello", new GCons[String]("Scala", EmptyList))

  println(listOfStrings.toString)
}
