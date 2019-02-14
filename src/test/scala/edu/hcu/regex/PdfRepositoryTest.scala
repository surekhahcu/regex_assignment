package edu.hcu.regex

import org.scalatest.{BeforeAndAfter, FunSuite}
import slick.driver.MySQLDriver.api._

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.control.NonFatal

class PdfRepositoryTest extends FunSuite with BeforeAndAfter {

  val pdf = new PdfRepository
  val database = new DBConnection

  before {
    try {
      Await.result(database.db.run(pdf.filesTableQuery.schema.create), 10 seconds)
      pdf.create(FileData("This pdf content will always be available", Some(1)))
    } catch {
      case NonFatal(th) =>
        th.printStackTrace()
    }
  }

  after {
    try {
      Await.result(database.db.run(pdf.filesTableQuery.schema.drop), 10 seconds)
    } catch {
      case NonFatal(th) =>
        th.printStackTrace()
    }

  }

  test("Inserting Pdf file") {
    val resultFuture: Future[Int] = pdf.create(FileData("This Is Dummy Pdf Data"))
    val result: Int = Await.result(resultFuture, 10 seconds)
    assert(result === 2)

  }

  test("Updating Pdf file") {
    val resultFuture: Future[Int] = pdf.update(FileData("This content is for update the pdf content", Some(1)))
    val result: Int = Await.result(resultFuture, 10 seconds)
    assert(result === 1)
  }

  test("Deleting Pdf") {
    val resultFuture: Future[Int] = pdf.delete(1)
    val result: Int = Await.result(resultFuture, 10 seconds)
    assert(result === 1)

  }

  test("Fetch Pdf Data By Pdf Id") {
    val resultFuture: Future[Option[FileData]] = pdf.getById(1)
    val result: Option[FileData] = Await.result(resultFuture, 10 seconds)
    assert(result === Some(FileData("This pdf content will always be available", Some(1))))
  }

  test("Fetch All Pdfs") {
    val resultFuture: Future[List[FileData]] = pdf.getAll()
    val result = Await.result(resultFuture, 10 seconds)
    assert(result === List(FileData("This pdf content will always be available", Some(1))))
  }

}
