package test.contact

import poc.bpm.Activity
import poc.bpm.Action
import poc.bpm.Participant

class BreakManagement(resource: Break) extends Activity {

  object validateBreak extends Action[Boolean, Unit](this, resource.cancel.isEnabled || resource.reject.isEnabled, doValidateBreak)
  object closeBreak extends Action[Unit, Unit](this, resource.close.isEnabled, todo)
  object cancelBreak extends Action[Unit, Unit](this, resource.cancel.isEnabled, todo)

  object Operator extends Participant[Operator](this)

  object Supervisor extends Participant[Supervisor](this)

  Operator.grant(cancelBreak, closeBreak)
  Supervisor.grant(validateBreak)

  def doValidateBreak(accept: Boolean) {
    if (accept) {
      resource.accept.invoke(null)
    } else {
      resource.reject.invoke(null)
    }
  }

  def todo(void: Unit) {}
}