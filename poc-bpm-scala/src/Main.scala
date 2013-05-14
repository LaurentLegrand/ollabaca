import test.contact.Break
import test.contact.BreakManagement
import test.contact.Operator
import test.contact.Supervisor
import scala.concurrent.Await
import scala.concurrent.duration.FiniteDuration

object Main extends App {

  //def main(args: Array[String]) {

  // create roles
  val supervisor = new Supervisor
  val operator = new Operator

  // create break and activity
  val b = new Break
  val breakManagement = new BreakManagement(b)

  // 
  Await.result(breakManagement.operator.set.call(operator), FiniteDuration(1, "seconds")) //.wait()
  Await.result(breakManagement.supervisor.set.call(supervisor), FiniteDuration(1, "seconds")) //.wait()
   //.wait()

  println(supervisor.breaksToValidate.isEmpty)

  //}

}