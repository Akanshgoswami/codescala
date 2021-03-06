package com.app.dbda
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.expressions.Window

object BusinessComputation extends App with Connection {


/*
  val data = spark.read.format("csv")
             .options(Map("header"->"true","inferschema"-> "true"))
             .load("file:///home/hduser/Documents/ds/SFFoodProgram/businesses_plus.csv")*/
//data.printSchema()
//  data.show(10,false)

  import spark.implicits._
  import org.apache.spark.sql.functions.struct
  import org.apache.spark.sql.functions.{concat, lit,udf}
  import org.apache.spark.sql.functions._
/*
var df = data.select(data.col("city") as ("bcity"),$"owner_city",$"business_id")
//  df.show(5)

//df.piv

var pvdf=  df.groupBy("bcity").pivot("owner_city").sum("business_id")
 pvdf.show(5)*/

 /* val empDF = spark.createDataFrame(Seq(
    (7369, "SMITH", "CLERK", 7902, "17-Dec-80", 800, 20, 10),
    (7499, "ALLEN", "SALESMAN", 7698, "20-Feb-81", 1600, 300, 30),
    (7521, "WARD", "SALESMAN", 7698, "22-Feb-81", 1250, 500, 30),
    (7566, "JONES", "MANAGER", 7839, "2-Apr-81", 2975, 0, 20),
    (7654, "MARTIN", "SALESMAN", 7698, "28-Sep-81", 1250, 1400, 30),
    (7698, "BLAKE", "MANAGER", 7839, "1-May-81", 2850, 0, 30),
    (7782, "CLARK", "MANAGER", 7839, "9-Jun-81", 2450, 0, 10),
    (7788, "SCOTT", "ANALYST", 7566, "19-Apr-87", 3000, 0, 20),
    (7839, "KING", "PRESIDENT", 0, "17-Nov-81", 5000, 0, 10),
    (7844, "TURNER", "SALESMAN", 7698, "8-Sep-81", 1500, 0, 30),
    (7876, "ADAMS", "CLERK", 7788, "23-May-87", 1100, 0, 20),
    (7876, "ADAMS", "CLERK", 7788, "23-May-87", 1100, 0, 20)
  )).toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")


empDF.show(10,false)

//  val wndspec = Window.partitionBy("deptno","empno").orderBy($"sal".desc).rangeBetween()
//  val wndspec = Window.partitionBy("deptno","empno").orderBy($"sal".desc)
  val wndspec = Window.partitionBy("deptno").orderBy($"sal".desc)

//  rank().over(wndspec)

//  empDF.select($"*",rank().over(wndspec) as("rank"))
//  empDF.select($"*",dense_rank().over(wndspec) as("rank"))
  empDF.select($"*",row_number().over(wndspec) as("rank"))
//    .where($"rank"=== 1)
  .show(20,false)

*/
/*  val data = spark.read.format("csv")
    .options(Map("header"->"true","inferschema"-> "true","sep"->",")).load("file:///home/hduser/Documents/data.csv")

 data.show(10)

  data.write.option("quote","\u0000").options(Map("header"->"true","sep"->",")).mode(SaveMode.Overwrite).csv("file:///home/hduser/Documents/data_inter.csv")

  val data1 = spark.read.format("csv")
    .options(Map("header"->"true","inferschema"-> "true","sep"->",")).load("file:///home/hduser/Documents/data_inter.csv")

  data1.show(10)
  data1.printSchema()*/

/*  val empDF = spark.createDataFrame(Seq(
    (7369, "SMITH", "CLERK", 7902, "17-Dec-80", 800, 20, 10),
    (7499, "ALLEN", "SALESMAN", 7698, "20-Feb-81", 1600, 300, 30),
    (7521, "WARD", "SALESMAN", 7698, "22-Feb-81", 1250, 500, 30),
    (7566, "JONES", "MANAGER", 7839, "2-Apr-81", 2975, 0, 20),
    (7654, "MARTIN", "SALESMAN", 7698, "28-Sep-81", 1250, 1400, 30),
    (7698, "BLAKE", "MANAGER", 7839, "1-May-81", 2850, 0, 30),
    (7782, "CLARK", "MANAGER", 7839, "9-Jun-81", 2450, 0, 10),
    (7788, "SCOTT", "ANALYST", 7566, "19-Apr-87", 3000, 0, 20),
    (7839, "KING", "PRESIDENT", 0, "17-Nov-81", 5000, 0, 10),
    (7844, "TURNER", "SALESMAN", 7698, "8-Sep-81", 1500, 0, 30),
    (7876, "ADAMS", "CLERK", 7788, "23-May-87", 1100, 0, 20),

    (7876, "ADAMS", "CLERK", 7788, "23-May-87", 1100, 0, 20)
  )).toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")

//  empDF.show(10,false)

  println("=======>>>>>>>><<<<<<<<"+empDF.count)



  val empDF2 = spark.createDataFrame(Seq(
    (7369, "SMITH", "CLERK", 7902, "17-Dec-80", 800, 20, 10),
    (7499, "ALLEN", "SALESMAN", 7698, "20-Feb-81", 1600, 300, 30),
    (7521, "WARD", "SALESMAN", 7698, "22-Feb-81", 1250, 500, 30),
    (7566, "JONES", "MANAGER", 7839, "2-Apr-81", 2975, 0, 20),
    (7654, "MARTIN", "SALESMAN", 7698, "28-Sep-81", 1250, 1400, 30)
  )).toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")

//  empDF2.show(10,false)

  println("=======>>>>>>>><<<<<<<<"+empDF2.count)


val DF = empDF.except(empDF2)
//DF.show(50)

  println("=======>>>>>>>><<<<<<<<"+DF.count)

  val df =empDF.union(empDF2).except(empDF.intersect(empDF2))

      df.show(50)
  println("===========>>"+df.count())


  */


//  val arrayList:List[(String,Any)] =List(("akansh",454),("san",5454))
//
//  val schema = StructType(Array(StructField("Name",StringType,true),
//    StructField("Values",IntegerType,true)))
//
//  val rdd = spark.sparkContext.parallelize(arrayList)
//    .map(x => Row(x._1,x._2.asInstanceOf[Number].intValue()))
//
//  val df = spark.sqlContext.createDataFrame(rdd,schema)
//  df.printSchema()
//
//  df.show()

  SealedTrait.mi(Red)
  SealedTrait.mi(Yellow)

}
