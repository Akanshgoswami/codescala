package com.app.method

import scala.io.Source._

object MethodExample extends App {
/*//  Take input from console..
 println( scala.io.Source.stdin.getLines().take(2).map(_.toInt).sum)

  println("enter 5 number")

 println( scala.io.Source.stdin.getLines().take(5).map(_.toInt).sum)*/


// Reccursion==

  def f(n:Int) :Unit ={println("Hello world"+n.toString); if(n>1)f(n-1)}
  f(3)

  def d(n:Int) :Unit ={  if(n>1)d(n-1); println(n+"Hello world");}
  d(3)
}
