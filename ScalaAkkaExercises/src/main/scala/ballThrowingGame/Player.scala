package ballThrowingGame

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Player(val name: String, val players: ArrayBuffer[ActorRef]) extends Actor with ActorLogging {
  override def receive: Receive = {
    case Player.Ball(count) => {
      println(name + ": Throw count=" + count)
      Thread.sleep(500)
      players.filter(_ != self)(Random.nextInt(players.size-1)) ! Player.Ball(count + 1)
    }
  }

  override def unhandled(msg: Any): Unit = msg match {
    case msg: String => log.info(s"Unexpected message: '$msg'")
    case msg => super.unhandled(msg)
  }
}

object Player {
  def props(playerName: String, playerArr: ArrayBuffer[ActorRef]) = Props(classOf[Player], playerName, playerArr)
  case class Ball(count: Int)
}
