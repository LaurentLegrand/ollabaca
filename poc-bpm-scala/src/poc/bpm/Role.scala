package poc.bpm

class Role extends Resource {

  object Participate extends Operation[Participant[_], Unit](this, true, doParticipate)

  object StopParticipation extends Operation[Participant[_], Unit](this, true, doStopParticipation)

  var participations = Set.empty[Participant[_]]

  //name: String

  def doParticipate(participant: Participant[_]) {
    participations += participant
  }

  def doStopParticipation(participant: Participant[_]) {
    participations -= participant
  }

}