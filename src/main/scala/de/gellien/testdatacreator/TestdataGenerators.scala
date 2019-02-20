package de.gellien.testdatacreator

import org.scalacheck.Gen
import org.scalacheck.Arbitrary

case class Person(anrede: String, titel: String, vorname: String, name: String) {
  def repr = s"""Person("$anrede", "$titel", "$vorname", "$name")"""
  override def toString = if (titel.isEmpty()) s"$anrede $vorname $name" else s"$anrede $titel $vorname $name"
}

object TestdataGenerators {
  val intGen = Arbitrary.arbitrary[Int]
  val doubleGen = Arbitrary.arbitrary[Double]
  val stringGen = Arbitrary.arbitrary[String]

  val lottoGen: Gen[Seq[Int]] = Gen.pick(6, 1 to 49)

  val titelGen = Gen.oneOf("", "Dr.", "Prof.")
  val titelOptGen = Gen.option(Gen.oneOf("Dr.", "Prof."))
  val titelFreqGen = Gen.frequency(
    (7, Gen.const("")),
    (2, Gen.const("Dr.")),
    (1, Gen.const("Prof.")))

  val anredeGen = Gen.oneOf("Frau", "Herr")
  val vornameFrauGen = Gen.oneOf("Alisa", "Anja", "Ann", "Barbara", "Caroline", "Christiane", "Doris", "Julia", "Karoline", "Pauline", "Samantha", "Ulrike")
  val vornameHerrGen = Gen.oneOf("Adrian", "Alfred", "André", "Anton", "Bernd", "Conner", "Harald", "Heinrich", "Lennart", "Max", "Rüdiger", "Valentin")
  def vornameGen(anrede: String) = if (anrede == "Frau") vornameFrauGen else vornameHerrGen
  val nachnameGen = Gen.oneOf("Abels", "Blum", "Böhm", "Ebner", "Gordon", "Grundmann", "Hofbauer", "Kuntz", "Peter", "Ramirez", "Schultheiss", "Voss", "Wirtz")

  val personGen = for {
    //    titel <- titelGen
    titel <- titelFreqGen
    anrede <- anredeGen
    vorname <- vornameGen(anrede)
    name <- nachnameGen
  } yield Person(anrede, titel, vorname, name)
}
