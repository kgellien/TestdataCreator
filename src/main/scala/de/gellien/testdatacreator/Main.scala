package de.gellien.testdatacreator

import TestdataGenerators._
import org.scalacheck.Gen

object Main {

  def showSamples[T](header: String, gen: Gen[T], n: Int) = {
    println(f"\n$header:")
    val result = for (i <- 1 to n) yield gen.sample
    for ((line, idx) <- result.zipWithIndex) {
      line match {
        case Some(entry) => println(f"  $idx%2d: >$entry<")
        case None        => println(f"  $idx%2d: None")
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println("=========== Main Start")
    val n = 5

    showSamples("Some integers", intGen, n)
    showSamples("Lottery numbers", lottoGen, n)
    showSamples("Some doubles", doubleGen, n)

    showSamples("Some strings (unicode!)", stringGen, n)
    showSamples("Some alpha strings", Gen.alphaStr, n)

    showSamples("Some (academic titles", titelGen, n)

    val personen = showSamples("Some people", personGen, n)

    val pRepr = personen.map { case Some(p) => p.repr }.toList  //.mkString("List(", ", ", ")")
    println(pRepr)

    println("=========== Main End")
  }
}
