package ballThrowingGame

import akka.actor.{ActorRef, ActorSystem}
import scala.collection.mutable.ArrayBuffer

object BallGameTest extends App {
  val system = ActorSystem("BallGame")
  val amountOfPlayers = 2
  val players: ArrayBuffer[ActorRef] = ArrayBuffer();
  for (i <- 0 to amountOfPlayers) {
    val name = "Player" + (i + 1)
    players.addOne(system.actorOf(Player.props(name, players)))
  }
  players(0) ! Player.Ball(1)
}