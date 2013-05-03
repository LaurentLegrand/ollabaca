package poc.bpm

class Activity extends Resource {

  var actions: Set[Action[_, _]] = Set.empty

  def addAction(action: Action[_, _]) {
    actions += action
  }

}