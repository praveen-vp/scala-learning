package com.pvp
package experiments

/**
 * Created by praveen-vp on 12/3/2020
 *
 */
abstract class MyList {

  /*
    single linked list of integers
    head - first element of the list
    tail - the reminder of the list
    add(int)
    isEmpty
    toString  -- override
   */

  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(newNumber: Int): MyList

  override def toString: String = "[" + printElements + "]"

  // print element is a polymorphic call
  def printElements: String

}

// objects can extend classes
object Empty extends MyList {

  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(newNumber: Int): MyList = new Cons(newNumber, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {

  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(newNumber: Int): MyList = new Cons(newNumber, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object MyListTest extends App {

  val firstList = new Cons(1, Empty)
  println(firstList.head)
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list.tail.head)
  println(list.isEmpty)
  println(list.add(4).head)
  println(list.toString)
}