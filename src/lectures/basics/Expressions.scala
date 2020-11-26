package com.pvp
package lectures.basics

/**
 * Created by praveen-vp on  11/26/2020
 *
 */
object Expressions extends App {

  val x = 1 + 3
  println(x)
  println(2 + 3 * 9)

  // MATH EXPRESSIONS
  //  + - *  / %
  //  & | ^
  // >> << right shift , left shift
  // >>> <<<  right shift with zero extension

  // RELATIONSHIP EXPRESSIONS
  // ==,  != , >,  >=,  <,  <=
  println(1 == x)

  // BOOLEAN EXPRESSIONS
  println(!(1 == x))
  // !, &&, ||

  var aVariable = 3
  aVariable += 3
  println(aVariable)
  // other expressions like one above
  // -+, *=, /=  ------ side effects


  // INSTRUCTIONS vs EXPRESSIONS

  // IF Expression
  // if in scala is an expression
  println(if (x == 1) 4 else 0)
  val aCondition = true

  println(if (aCondition) 1 else 0)

  // LOOPS are there in scala, it is like imperative programming, as a functional language avoid
  // using these loops in scala

  // FOR DEMONSTRATION PURPOSE ONLY
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING in Scala is an EXPRESSION!!!


  val aWeirdValue = (aVariable = 3) // Unit is the type returned by this expression
  println(aWeirdValue) // () similar to void in other languages

  // SIDE EFFECTS :: side effects in scala are expressions returning units
  // eg: while, reassigning, print etc

  // CODE BLOCKS
  val aCodeBlock = {
    var x = 2
    var y = x + 2
    if (x > 9) "0" else "1"
  }

  // this code block returns the value to the 'aCodeBlock' which is the value of the last
  // statement in the code block


  // exercises
  /*
    1 . diiff between "hello world" vs println("hello World")
    Ans : "hello world" is a string literal
          println("hello world") is an expression, and a 'side effect'
   */

  val someVal = {
    2 < 3
  }

  println(someVal) // return true as 2 < 3

  var someOtherVal = {
    if (someVal) 222 else 111
    44
  }

  println(someOtherVal) // return 44, it is the last expression of the code block
}
