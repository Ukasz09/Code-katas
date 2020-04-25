package pingPongGame

import akka.actor.{Actor, ActorLogging, PoisonPill, Props}

class Player(val name: String, val ballHitMsg: String) extends Actor with ActorLogging {
  override def receive: Receive = {
    case Player.Ball(remainingBounces) => if (remainingBounces > 0) {
      println(name + ": " + ballHitMsg)
      sender ! Player.Ball(remainingBounces - 1)
    } else context.system.terminate()
  }

  override def unhandled(msg: Any): Unit = msg match {
    case msg: String => log.info(s"Unexpected message: '$msg'")
    case msg => super.unhandled(msg)
  }
}

object Player {
  def props(playerName: String, ballHitMsg: String) = Props(classOf[Player], playerName, ballHitMsg)

  case class Ball(remainingBounces: Int)

}