package codechef

//import scala.io.
import scala.io.Source


object ATM  extends App {

// val sum = scala.io.Source.stdin.getLines().take(2).map(_.toInt).sum
//  println(sum)

 val balance:Int = 5000

// def blnc(amt:Double):Double={
// balance - (amt+ .50)
// }


//  Function literal...

 val blnc = (a:Double) => (balance - (a+ .50))


 val withDrawPayment:List[Double] = List(69000,455.5,500,496,-1)

 withDrawPayment.foreach(row => {
        row  match {
         case row if(row%5==0 && row < (balance- .5) && !(row <0)) => println(blnc(row))
         case row if(row%5 !=0 ) => println("Please enter the amount in the multiple of 5.")
         case row if (row > balance) => println("Insufficient Funds.")
         case row if (row < 0) => println("Provide valid amount.")
        }


 })

 withDrawPayment.map(row=> println(row))


}

