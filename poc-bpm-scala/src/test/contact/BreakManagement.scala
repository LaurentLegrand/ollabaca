package test.contact

import poc.bpm.Activity
import poc.bpm.Action
import poc.bpm.Participant

class BreakManagement(resource: Break) extends Activity {

  object validateBreak extends Action[Boolean, Void](this, () => this.resource.cancel.isEnabled || this.resource.reject.isEnabled,
    this.doValidateBreak);

  object closeBreak extends Action[Void, Void](this, () => this.resource.close.isEnabled(),
    this.todo);

  object cancelBreak extends Action[Void, Void](this, () => this.resource.cancel.isEnabled(),
    this.todo);

  object Operator extends Participant[Operator](this);

  object Supervisor extends Participant[Supervisor](this);

  this.Operator.grant(this.cancelBreak, this.closeBreak);
  this.Supervisor.grant(this.validateBreak);

  def doValidateBreak(accept: Boolean): Void = {
    if (accept) {
      this.resource.accept.invoke(null);
    } else {
      this.resource.reject.invoke(null);
    }
    return null;
  }

  def todo(void: Void): Void = {
    return null
  }
}