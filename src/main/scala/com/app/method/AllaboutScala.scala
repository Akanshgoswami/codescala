package com.app.method

import com.app.dbda.Connection



object  AllaboutScala extends App with Connection {

// Pattern Matching in scala

/*
Different Types of Pattern matching.
 */
//  Simple Match
   val bools = Seq(true,false)
    for (bool<-bools){
      bool match {
        case true => println("gots Heads")
        case  false => println("gots Tails")
      }
    }

//  ============================Handling case Sensitive in pattern matching===================

  implicit class Stringignorecase (val s :String) {

    def insensitive  = new {
      def unapply(other:String) ={
        println("ssssssssssssss"+s)
        println("ssssssssssssss"+other)
        s.equalsIgnoreCase(other)}
    }
  }


//  val test1 = "all".insensitive
  val test1 = "all"

var stage = "AlL"
  stage match {
    case test1  if( test1.equalsIgnoreCase(stage)) => println("Match")
    case _ => println("Not Match")
  }





}
