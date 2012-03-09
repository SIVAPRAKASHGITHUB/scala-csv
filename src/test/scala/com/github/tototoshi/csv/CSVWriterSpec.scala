package com.github.tototoshi.csv

import java.io.FileWriter

import org.scalatest.FunSpec
import org.scalatest.matchers._

class CSVWriterSpec extends FunSpec with ShouldMatchers with Using {
  def fixture = new {

  }

  describe("CSVSpec") {

    it("write all lines to file") {
      using (new CSVWriter(new FileWriter("test.csv"))) { writer =>
        writer.writeAll(List(List("a", "b", "c"), List("d", "e", "f")))
      }

      io.Source.fromFile("test.csv").getLines.mkString should be (""""a","b","c""d","e","f"""")

      new java.io.File("test.csv").delete()
    }

    it("write single line to file") {
      using (new CSVWriter(new FileWriter("test.csv"))) { writer =>
        writer.writeRow(List("a", "b", "c"))
        writer.writeRow(List("d", "e", "f"))
      }

      io.Source.fromFile("test.csv").getLines.mkString should be (""""a","b","c""d","e","f"""")

      new java.io.File("test.csv").delete()
    }

  }
}

