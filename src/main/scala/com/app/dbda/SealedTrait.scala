package com.app.dbda
//
//sealed trait test {
//  val te = "This is the test"
//}
//
//class No(se:String) extends test {
//  override val te = se
//}
//
//class yes extends test{
//  te
//}
//case class ded() extends test



sealed trait Color {
  val ds ="Hello World"
  def sum(x:Int,y:Int)={
    x+y
  }
}
object Red extends Color {
  override val ds ="new world"
  val value = 45

  override def sum(x: Int, y: Int): Int = {
    x-y
  }
}

object Yellow extends Color
//object Green extends Color

object SealedTrait  {

/*
val ds = new No("dddd")
  println(ds.te)
  val ys = new yes
  println(ys.te)

*/


  def mi (color: Color) = color match {
    case Red => {
      println(Red.ds)
      println(Red.value)
      println(Red.sum(25,10))
    }
    case Yellow => {
      println("This is YEllow")
      println(Yellow.ds)
      println(Yellow.sum(25,1500))
    }
  }






}
