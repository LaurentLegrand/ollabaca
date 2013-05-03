package poc.bpm

class Participant[R <: Role](activity: Activity) {

  object Set_ extends Operation[R, Unit](activity, true, doSet)

  object Unset extends Operation[R, Unit](activity, role != null, doUnset)

  var role: Option[R] = None

  var actions = Set.empty[Action[_, _]]

  def grant(action: Action[_, _]*) {
    actions ++= action
  }

  def deny(action: Action[_, _]*) {
    actions --= action
  }

  def doSet(r: R) {
    if (role.isDefined) {
      doUnset(role.get)
    }
    if (r != null) {
      role = Some(r)
      r.Participate.invoke(this)
    }
  }

  def doUnset(r: R) {
    role.get.StopParticipation.invoke(this)
    role = None
  }

}