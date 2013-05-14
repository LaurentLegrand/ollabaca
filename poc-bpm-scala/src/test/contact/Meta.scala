package test.contact

import scala.annotation.StaticAnnotation
import poc.bpm.Action

trait ValidateBreakInfo { self: Action[_, _] =>
//  def isBreakManagement = self.activity match {
//    case b: BreakManagement => b == self
//    case _ => false
//  }
}

object Meta {
  object BreakMeta {
    object AcceptInfo
    object RejectInfo
  }
}