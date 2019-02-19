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

    //    val pRepr = personen.map(_.repr).mkString("List(", ", ", ")")
    //    println(pRepr)
    //    val ps = List(Person("Frau", "", "Ann", "Tesch"), Person("Herr", "Dr.", "Max", "Castro"), Person("Frau", "Dr.", "Fenja", "Stefan"), Person("Herr", "", "Raphael", "Caspari"), Person("Herr", "Dr.", "Adrian", "Kautz"))
    //    ps foreach println

    println("=========== Main End")
  }
}
