package com.app.method

case class dataOperations(day:Int,doy:Int,month:Int,year:Int,
                          precip:Double,snow:Double,tave:Double,tmax:Double,tmin:Double)



object dataOperations extends App {

  def toDoubleOrNeg(s:String):Double ={
    try{
      s.toDouble
    }
    catch {
      case _:NumberFormatException => -1
    }
  }
//  /home/hduser/Documents/akansh/dataCO2Emission.csv
  val source = scala.io.Source.fromFile("/home/hduser/Documents/akansh/dataset/dataCO2Emission.csv")
  val lines = source.getLines().drop(1)
//  val lines = source.getLines().take(1)
  lines.take(10).foreach(println)

/* val data = lines.map{ line =>
    val p =line.split(",")
    dataOperations(p(0).toInt,p(1).toInt,p(2).toInt,p(4).toInt,p(5).toDouble,p(6).toDouble,
      p(7).toDouble,p(8).toDouble,p(9).toDouble)}.toArray*/
/*
val data1 = lines.filterNot(_.contains(",.,")).map{ line =>

  val p =line.split(",")
  p.indexOf()
  dataOperations(p(0).toInt,p(1).toInt,p(2).toInt,p(4).toInt,p(5).toDouble,p(6).toDouble,
    p(7).toDouble,p(8).toDouble,p(9).toDouble)}.toArray*/

//  data1.take(5).foreach(println)

  val data = lines.flatMap{ line =>
    val p =line.split(",")

    if((7)=="." || p(8) == "." || p(9) == ".") Seq.empty else Seq(
    dataOperations(p(0).toInt,p(1).toInt,p(2).toInt,p(4).toInt,toDoubleOrNeg(p(5)),
      toDoubleOrNeg(p(6)),
      toDoubleOrNeg(p(7)),toDoubleOrNeg(p(8)),toDoubleOrNeg(p(9))))}.toArray

/*println(data.length)


data.take(5).foreach(println)*/

/*

val maxTemp = data.map(_.tmax).filter(_ != null).max
val hotDay = data.filter(_.tmax == maxTemp)
  println(s"hot day is ${hotDay.mkString(",")}")


  val hotdays1 = data.maxBy(_ .tmax)
  println(s"hotday1 is ${hotdays1}")

  val hotdays2 = data.reduceLeft((d1,d2)=> if (d1.tmax >= d2.tmax) d1 else d2)
  println(s"hotday2 is ${hotdays2}")
*/




val rainyCount = data.count(_.precip>=1.0)
  println(s"$rainyCount")
//var da= data.take(1000000)
var (rainySum, rainyCount2) = data.foldLeft(0.0 -> 0) {
  case((a,b) , td) =>
//    println(a +"," + b+ " ,"+ td)
    if (td.precip <1.0 ) (a,b) else (a +td.tmax,b+1)
}


println(s"$rainySum   and $rainyCount2")


  val  rainyTemp = data.flatMap(
  t => {
//    println(t.toString+"............")
    if (t.precip<1.0) Seq.empty else Seq(t.tmax)}
  )
//  println(rainyTemp.sum/rainyTemp.length)


val monthGroups = data.groupBy(_ .month)

  println(monthGroups.size)

val monthlyTemp = monthGroups.map(
  {
    case (m,days) =>
      m -> days.foldLeft(0,0) ((sum ,td) => sum + (td.tmax/days.length) )
  }


)

source.close()

}
