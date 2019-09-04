package com.app.dbda

object BusinessComputation extends App with Connection {

  val data = spark.read.format("csv")
             .options(Map("header"->"true","inferschema"-> "true"))
             .load("file:///home/hduser/Documents/ds/SFFoodProgram/businesses_plus.csv")
//data.printSchema()
//  data.show(10,false)

  import spark.implicits._
  import org.apache.spark.sql.functions.struct
  import org.apache.spark.sql.functions.{concat, lit,udf}
  import org.apache.spark.sql.functions._

var df = data.select(data.col("city") as ("bcity"),$"owner_city",$"business_id")
//  df.show(5)

//df.piv

var pvdf=  df.groupBy("bcity").pivot("owner_city").sum("business_id")
 pvdf.show(5)



}
