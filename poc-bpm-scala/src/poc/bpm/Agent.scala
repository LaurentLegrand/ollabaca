package poc.bpm

abstract class Agent extends Resource {

}

class Group extends Agent {
  
  var memberships = Set.empty[Membership]
  
  var groups = Set.empty[Group]
  
}


class Membership(group: Group, role: Role) {
  
  var members = Set.empty[User]
  
}

class User extends Agent {
  
}