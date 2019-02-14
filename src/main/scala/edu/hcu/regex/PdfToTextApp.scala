package edu.hcu.regex

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object PdfToTextApp extends App {

  val fileList: List[String] = PdfToText.getFilesFromDir("/home/surekha/testing/")
  val cleanedContentList: List[FileData] = fileList.map{file=>PdfCleaner.clean(file)}
    .map(data => FileData(data))

  val repository: PdfRepository = new PdfRepository

  val futureOfFutureResult: List[Future[Int]] = cleanedContentList.map { pdf => repository.create(pdf) }

  val futureResult = Future.sequence(futureOfFutureResult)

  val result = Await.result(futureResult, 10 seconds)

  val futureList = repository.getAll()

  val list = Await.result(futureList, 10 seconds)

  println(list)
// println( PdfToText.getContent("/home/surekha/testing/testdata.pdf/"))

}
/*{
val file:String = PdfToText.getContent("/home/surekha/testing/testdata.pdf")
val cleanedContent: String= PdfCleaner.clean(file)
  //.map(data => FileData(data))

  val repository: PdfRepository = new PdfRepository

  val futureOfFutureResult: Future[Int] =repository.create(FileData(cleanedContent))

  val futureResult = Future(futureOfFutureResult)

  val result = Await.result(futureResult, 10 seconds)

  val futureList = repository.getAll()

  val list = Await.result(futureList, 10 seconds)

  println(list)
  // println( PdfToText.getContent("/home/surekha/testing/testdata.pdf/"))
}*/