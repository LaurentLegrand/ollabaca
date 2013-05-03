package poc.bpm

class Action[I, O](
  activity: Activity,
  precondition:  => Boolean,
  body: I => O) extends Operation[I, O](activity, precondition, body) {

  activity.addAction(this)

}