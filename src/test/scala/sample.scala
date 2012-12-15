package com.dropboxivity
import collection.mutable.Stack
import org.scalatest._
import org.scalatest.matchers._
import org.specs2.mutable._
import scala.collection.immutable._
import org.scala_tools.time.Imports._

class StackSpec extends FlatSpec with ShouldMatchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should equal (2)
    stack.pop() should equal (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    evaluating { emptyStack.pop() } should produce [NoSuchElementException]
  }
}

object ArithmeticSpec extends Specification {
  "Arithmetic" should {
    "add two numbers" in {
      1 + 1 mustEqual 2
    }
    "add three numbers" in {
      1 + 1 + 1 mustEqual 3
    }
    "one revision returns empty" in {
      def a = List(DateTime.now)
      ScalaProject.compile(a) mustEqual Nil
    }
    "one second wide revisions returns one record" in {
      val a = DateTime.now
      def b = a.plusSeconds(1)
      ScalaProject.compile(List(a,b)) mustEqual List(List(a,b,1000))
    }

    "datatimes should be in descending order" in {
    	val a = DateTime.now
    	val b = a.plusMinutes(1)
      ScalaProject.compile(List(a,b)) mustEqual List(List(a,b,60000))
      ScalaProject.compile(List(b,a)) must throwA(new Exception("Revisions are not in order"))

    }
  }
}