package com.app.dbda

object BusinessComputation extends App with Connection {

  val data = spark.read.format("csv").options(Map("header"->"true","inferschema"-> "true")).load("file:///home/hduser/Documents/ds/SFFoodProgram/businesses_plus.csv")

  data.show(10,false)

  import spark.implicits._
  import org.apache.spark.sql.functions.struct
  import org.apache.spark.sql.functions.{concat, lit,udf}
  import org.apache.spark.sql.functions._








}
