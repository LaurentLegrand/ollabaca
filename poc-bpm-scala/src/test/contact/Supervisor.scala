package test.contact

import poc.bpm.Role
import poc.bpm.Action

class Supervisor extends Role {

  /**
   * Contains all the breaks to validate.
   */
  def breaksToValidate =
    for {
      p <- participations
      a <- p.actions
      if a.isInstanceOf[ValidateBreakInfo]
    } yield a

//  private def isValidate(a: Action[_, _]) =
//    a.activity match {
//      case b: BreakManagement => a == b.validateBreak
//      case _ => false
//    }

  //    participations.map(p => p.actions).flatten.filter{
  //      case a: BreakManagement => a.ac
  //    a => a.activity.isInstanceOf[BreakManagement]
  //      && a == a.activity.asInstanceOf[BreakManagement].validateBreak)

  //Set[Action[Void, Boolean]] 

}