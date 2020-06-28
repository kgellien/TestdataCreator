//package de.gellien.testdatacreator

import de.gellien.testdatacreator.TestdataGenerators._
import org.scalacheck.Gen

object Demo {
  def sample[T](gen: Gen[T], n: Int = 5) = {
    val result = for (i <- 1 to n) yield gen.sample
    result
  }                                               //> sample: [T](gen: org.scalacheck.Gen[T], n: Int)scala.collection.immutable.In
                                                  //| dexedSeq[Option[T]]

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  println(sample(intGen))                         //> Vector(Some(1650194794), Some(-1008507458), Some(1), Some(2147483647), Some(
                                                  //| 1))
  println(sample(personGen))                      //> Vector(Some(Frau Alisa Kuntz), Some(Herr Max Blum), Some(Herr Valentin Blum)
                                                  //| , Some(Frau Ulrike Peter), Some(Frau Prof. Ann Abels))

}