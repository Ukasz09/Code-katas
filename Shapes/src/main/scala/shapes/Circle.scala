package main.scala.shapes

import main.scala.Logger

class Circle private(private[this] val radius: Double = 0.0) extends Shape2D {

  override def area(): Double = {
    math.Pi * radius * radius
  }
}

object Circle {
  def apply(radius: Double = 0.0): Circle = {
    if (radius < 0) {
      Logger.errorLog(getClass.getSimpleName + "-> Negative arg: radius=" + radius + ". Set to default")
      new Circle()
    } else new Circle(radius)
  }
}