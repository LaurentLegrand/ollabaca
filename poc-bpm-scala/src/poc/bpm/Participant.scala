package poc.bpm

class Participant[R <: Role](val activity: Activity) {
  
  activity.addParticipant(this)

  object set extends Operation[R, Unit](activity, true, doSet)

  object unset extends Operation[R, Unit](activity, role != null, doUnset)

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
      r.participate.call(this)
    }
  }

  def doUnset(r: R) {
    role.get.stopParticipation.call(this)
    role = None
  }

}