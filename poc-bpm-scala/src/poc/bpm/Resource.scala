package poc.bpm

//import collection.mutable.Set;

class Resource {

  var operations: Set[Operation[_, _]] = Set();

  def addOperation(operation: Operation[_, _]) {
    this.operations += operation;
  }

}