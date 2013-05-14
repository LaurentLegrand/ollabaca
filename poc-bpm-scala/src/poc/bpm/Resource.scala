package poc.bpm

//import collection.mutable.Set;

class Resource {

  /**
   * Set of operations exposed by this resource
   */
  var operations = Set.empty[Operation[_, _]]

  /**
   * Add an operation
   *
   * Can only be called by operation instances
   */
  def addOperation(operation: Operation[_, _]) {
    operations += operation
  }

  /**
   * Set of observers that are called after each operation execution
   */
  var observers = Set.empty[Resource => Unit]

  /**
   * Add an observer to this resource
   */
  object addObserver extends Operation[(Resource => Unit), Unit](this, true, doAddObserver)

  def doAddObserver(observer: Resource => Unit) {
    observers += observer
  }

}