package de.gellien.testdatacreator

import org.scalacheck.Gen
import org.scalacheck.Arbitrary

case class Person(titel: String, vorname: String, name: String, geschlecht: String) {
  def repr = s"""Person("$titel", "$vorname", "$name", "$geschlecht")"""
  override def toString = if (titel.isEmpty()) s"$vorname $name" else s"$titel $vorname $name"
}

object TestdataGenerators {
  val intGen: Gen[Int] = Arbitrary.arbitrary[Int]
  val doubleGen: Gen[Double] = Arbitrary.arbitrary[Double]
  val stringGen: Gen[String] = Arbitrary.arbitrary[String]

  val lottoGen: Gen[collection.Seq[Int]] = Gen.pick(6, 1 to 49)

  val titelGen: Gen[String] = Gen.frequency(
    (7, Gen.const("")),
    (2, Gen.const("Dr.")),
    (1, Gen.const("Prof.")))

  val geschlechter = List("m", "w", "d")

  val vornamenM = List("Adrian", "Alfred", "André", "Anton", "Bernd", "Conner", "Harald", "Heinrich", "Lennart", "Max", "Rüdiger", "Valentin")
  val vornamenW = List("Alisa", "Anja", "Ann", "Barbara", "Caroline", "Christiane", "Doris", "Julia", "Karoline", "Pauline", "Samantha", "Ulrike")
  val vornamenD = vornamenW ++: vornamenM

  val nachnamen = List("Abels", "Blum", "Böhm", "Ebner", "Gordon", "Grundmann", "Hofbauer", "Kuntz", "Peter", "Ramirez", "Schultheiss", "Voss", "Wirtz")

  val geschlechtGen: Gen[String] = Gen.oneOf(geschlechter)
  def vornameGen(geschlecht: String) = geschlecht match {
    case "m" => Gen.oneOf(vornamenM)
    case "w" => Gen.oneOf(vornamenW)
    case "d" => Gen.oneOf(vornamenD)
  }
  val nachnameGen = Gen.oneOf(nachnamen)

  val personGen: Gen[Person] = for {
    geschlecht <- geschlechtGen
    titel <- titelGen
    vorname <- vornameGen(geschlecht)
    name <- nachnameGen
  } yield Person(titel, vorname, name, geschlecht)
}
