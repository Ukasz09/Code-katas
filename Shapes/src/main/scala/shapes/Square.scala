package main.scala.shapes

import main.scala.Logger

class Square private(private[this] val sideLength: Double = 0.0) extends Shape2D {

  override def area(): Double = {
    sideLength * sideLength
  }
}

object Square {
  def apply(sideLength: Double = 0.0): Square = {
    if (sideLength < 0) {
      Logger.errorLog(getClass.getSimpleName + "-> Negative arg: sideLength=" + sideLength + ". Set to default")
      new Square()
    } else new Square(sideLength)
  }
}