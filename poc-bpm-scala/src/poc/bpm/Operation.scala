package poc.bpm

import scala.concurrent._
import ExecutionContext.Implicits.global

//import scala.concurrent.ops._

abstract class Operation[I, O](
  val resource: Resource,
  precondition: => Boolean,
  body: I => O) {

  resource.addOperation(this)

  def call(input: I): Future[O] = future {
    execute(input)
  }

  private def execute(input: I): O = {
    if (isEnabled)
      body(input)
    else
      throw new Error("NOT ENABLED")
  }

  def isEnabled: Boolean = precondition

}
