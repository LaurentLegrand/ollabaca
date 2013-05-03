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
  var state: State = Pending;

  object accept extends Operation[Void, Void](this, () => this.state == Pending, this.doAccept) {

  }

  object cancel extends Operation[Void, Void](this, () => this.state == Accepted || this.state == Pending, this.doAccept) {

  }

  object reject extends Operation[Void, Void](this, () => this.state == Pending, this.doAccept) {

  }

  object close extends Operation[Void, Void](this, () => this.state == Accepted, this.doAccept) {

  }

  //  object Reject extends Operation[Void, Void](this, () => true, null) {
  //
  //  }

  def doAccept(void: Void): Void = {
    this.state = Accepted;

    return null;
  }

}