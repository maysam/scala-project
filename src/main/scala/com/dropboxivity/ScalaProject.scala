package com.dropboxivity
import scala.collection.immutable.List
import org.scala_tools.time.Imports._

object ScalaProject extends App {
  def compile(L:List[DateTime]) : List[List[Any]] = L match {
	  case x::(y::c) => if(x<y) 
	    List(x,y, y.getMillis() - x.getMillis() ) :: compile(L.tail)
	    else
	      throw new Exception("Revisions are not in order")
	  case _ => Nil
  }
}
