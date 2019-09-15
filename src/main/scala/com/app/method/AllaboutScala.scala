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



}
