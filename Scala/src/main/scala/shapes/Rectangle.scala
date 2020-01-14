package main.scala.shapes

import main.scala.Logger

class Rectangle private(private[this] val height: Double = 0.0, private[this] val width: Double = 0.0) extends Shape2D {
  override def area(): Double = {
    height * width
  }
}

object Rectangle {
  def apply(height: Double = 0, width: Double = 0): Rectangle = {
    if (height < 0 || width < 0) {
      Logger.errorLog(getClass.getSimpleName + "-> Negative arg/args: height=" + height + ", width=" + width + ". Set to default")
      new Rectangle()
    } else new Rectangle(height, width)
  }
}