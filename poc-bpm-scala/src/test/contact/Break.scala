package test.contact

import poc.bpm.Resource
import poc.bpm.Operation
//import State._

object BreakState extends Enumeration {
  type State = Value
  val Pending, Accepted, Rejected, Closed = Value
}

import BreakState._

class Break extends Resource {

  /**
   * Initial state
   */
  var state: State = Pending

  object accept extends Operation[Unit, Unit](this, state == Pending, doAccept)
  object cancel extends Operation[Unit, Unit](this, state == Accepted || state == Pending, doAccept)
  object reject extends Operation[Unit, Unit](this, state == Pending, doAccept)
  object close extends Operation[Unit, Unit](this, state == Accepted, doAccept)

  //  object Reject extends Operation[Unit, Unit](this, () => true, null) {
  //
  //  }

  def doAccept(u: Unit) {
    state = Accepted
  }
}