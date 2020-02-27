package main.scala.shapes

import main.scala.Logger

class Triangle private(private[this] val height: Double = 0.0, private[this] val baseLine: Double = 0.0) extends Shape2D {
  override def area(): Double = {
    height * baseLine / 2
  }
}

object Triangle {
  def apply(height: Double = 0, baseline: Double = 0): Triangle = {
    if (height < 0 || baseline < 0) {
      Logger.errorLog(getClass.getSimpleName + "-> Negative args: height=" + height + ", baseLine=" + baseline + ". Set to default")
      new Triangle()
    } else new Triangle(height, baseline)
  }
}
