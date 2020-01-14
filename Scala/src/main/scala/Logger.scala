package main.scala

object Logger {
  def errorLog(info: String): Unit = {
    Console.err.println(info)
  }
}
