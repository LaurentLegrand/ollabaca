package poc.bpm

class Participant[R <: Role](activity: Activity) {

  object Set_ extends Operation[R, Void](this.activity, () => true, this.doSet);

  object Unset extends Operation[R, Void](this.activity, () => this.role != null, this.doUnset);

  var role: Option[R] = None;

  var actions: Set[Action[_, _]] = Set();

  def grant(action: Action[_, _]*) = {
    this.actions ++= action;
  }

  def deny(action: Action[_, _]*) = {
    this.actions --= action;
  }

  def doSet(role: R): Void = {
    if (this.role.isDefined) {
      this.doUnset(this.role.get);
    }
    if (role != null) {
      this.role = Some(role);
      this.role.get.Participate.invoke(this);
    }
    return null;
  }

  def doUnset(role: R): Void = {
    this.role.get.StopParticipation.invoke(this);
    this.role = null
    return null
  }

}