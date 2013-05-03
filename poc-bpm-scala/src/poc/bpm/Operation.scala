package poc.bpm

import scala.concurrent.Future

abstract class Operation[I, O](
  resource: Resource,
  precondition: () => Boolean,
  body: I => O) {

  resource.addOperation(this)

  def invoke(input: I): Future[O] = {
    //return this.body(input)
    // TODO
    return null
  }

  def isEnabled(): Boolean = {
    return this.precondition()
  }

}
