package poc.bpm

class Role extends Resource {

  object Participate extends Operation[Participant[_], Void](this, () => true, this.doParticipate);

  object StopParticipation extends Operation[Participant[_], Void](this, () => true, this.doStopParticipation);

  var participations: Set[Participant[_]] = Set();

  //name: String;

  def doParticipate(participant: Participant[_]): Void = {
    this.participations += participant;
    return null;
  }

  def doStopParticipation(participant: Participant[_]): Void = {
    this.participations -= participant;
    return null;
  }

}