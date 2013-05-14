package test.contact

import poc.bpm.Activity
import poc.bpm.Action
import poc.bpm.Participant

class BreakManagement(resource: Break) extends Activity {

  val validateBreak = new Action(this, resource.accept.isEnabled || resource.reject.isEnabled, doValidateBreak) with ValidateBreakInfo
  object closeBreak extends Action[Unit, Unit](this, resource.close.isEnabled, doCloseBreak)
  object cancelBreak extends Action[Unit, Unit](this, resource.cancel.isEnabled, doCancelBreak)

  object operator extends Participant[Operator](this)

  object supervisor extends Participant[Supervisor](this)

  operator.grant(cancelBreak, closeBreak)
  supervisor.grant(validateBreak)

  def doValidateBreak(accept: Boolean) {
    if (accept) {
      resource.accept.call()
    } else {
      resource.reject.call()
    }
  }

  def doCloseBreak(void: Unit) {
    resource.close.call()
  }

  def doCancelBreak(void: Unit) {
    resource.cancel.call()
  }
}