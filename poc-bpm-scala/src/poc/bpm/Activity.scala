package poc.bpm

class Activity extends Resource {

  var actions: Set[Action[_, _]] = Set();

  def addAction(action: Action[_, _]) {
    this.actions += action;
  }

}