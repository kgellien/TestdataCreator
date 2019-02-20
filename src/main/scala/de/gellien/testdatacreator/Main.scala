package de.gellien.testdatacreator

import TestdataGenerators._
import org.scalacheck.Gen

object Main {

  def showSamples[T](gen: Gen[T], n: Int = 10) = {
    val result = for (i <- 1 to n) yield gen.sample
    for ((line, idx) <- result.zipWithIndex) {
      line match {
        case Some(entry) => println(f"$idx%2d: >$entry<")
        case None        => println(f"$idx%2d: None")
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println("=========== Main Start")
    val n = 5

    showSamples(intGen, n)
    showSamples(smallEvenIntGen, n)
    showSamples(lottoGen, n)
    showSamples(doubleGen, n)

    //    showSamples(stringGen, n)
    //    showSamples(Gen.alphaStr, n)

    //    showSamples(titelFreqGen, n)

    //    val personen = showSamples(personGen, n)
    //
    //    val pRepr = personen.map { case Some(p) => p.repr }.mkString("List(", ", ", ")")
    //    println(pRepr)
    //    val ps = List(Person("Herr", "", "Anton", "Böhm"), Person("Frau", "Dr.", "Ulrike", "Blum"), Person("Herr", "", "Conner", "Wirtz"), Person("Frau", "", "Alisa", "Ramirez"), Person("Herr", "", "Alfred", "Peter"))
    //    ps foreach println

    println("=========== Main End")
  }
}
