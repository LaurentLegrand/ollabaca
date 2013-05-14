package poc.bpm

class Activity extends Resource {

  var actions: Set[Action[_, _]] = Set.empty
  
  def addAction(action: Action[_, _]) {
    actions += action
  }

  var participants: Set[Participant[_]] = Set.empty
  
  def addParticipant(participant: Participant[_]) {
    participants += participant
  }
 

}