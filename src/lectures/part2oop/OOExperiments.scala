package com.pvp
package lectures.part2oop

object OOExperiments extends App {

  val author = new Writer("praveen", "vp", 1990)
  val novel = new Novel("History of praveen", 2020, author)
  println(author.fullName)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val copyAuthor = new Writer("praveen", "vp", 1990)

  println(novel.isWrittenBy(copyAuthor))

  val counter = new Counter(10)
  counter.print
  counter.decrement.print
  counter.decrement(2).print
  counter.increment.increment.increment.decrement.print
}

sealed class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = firstName + " " + surname;
}

sealed class Novel(name: String, yearOfRelease: Int, author: Writer) {

  def authorAge: Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

class Counter(val count: Int) {
  def currentCount: Int = count;

  def increment: Counter = new Counter(count + 1)

  def decrement: Counter = new Counter(count - 1)

  def increment(increment: Int) = new Counter(count + increment)

  def decrement(decrement: Int) = new Counter(count - decrement)

  // recursive decrement
  def dec(count: Int): Counter = {
    if (count <= 0) this
    else increment.increment(count - 1)
  }

  // recursive increment
  def inc(count: Int): Counter = {
    if (count <= 0) this
    else decrement.decrement(count - 1)
  }

  def print = println(count)
}
