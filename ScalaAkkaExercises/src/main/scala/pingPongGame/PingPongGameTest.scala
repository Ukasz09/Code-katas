package pingPongGame

import akka.actor.ActorSystem

object PingPongGameTest extends App {
  val system = ActorSystem("PingPongGame")
  val player1 = system.actorOf(Player.props("Player1", "Ping"))
  val player2 = system.actorOf(Player.props("Player2", "Pong"))
  player1.tell(Player.Ball(10), player2)
}
