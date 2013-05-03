package poc.bpm

//import collection.mutable.Set;

class Resource {

  var operations = Set.empty[Operation[_, _]]

  def addOperation(operation: Operation[_, _]) {
    operations += operation
  }

}