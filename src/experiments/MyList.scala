package com.pvp
package experiments

/**
 * created by praveen-vp on 22-Jan-2021
 */
abstract class MyList {
  /*
   * head  -- first element of the list
   * tail -- remainder of the list
   * isEmpty -- is this is empty
   * add(int) -- add element to the list and return a new list
   * toString -- string representation of the list.
   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElement: String
  override def toString: String = "[" + printElement + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElement: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)

  def printElement: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElement
  }
}

object GenericListTest extends App {

  val list = new Cons(1, Empty)
  println(list.isEmpty)
  println(list.head)
  println(list.tail)

  val list2 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))

  println(list2.toString)
}