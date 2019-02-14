package edu.hcu.regex

import java.io.{File, FileInputStream}

import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.pdf.PDFParser
import org.apache.tika.sax.WriteOutContentHandler

import scala.util.Try


object PdfToText {

  def getContent(filePath: String): String = {
    val inputFile = new File(filePath)
    val inputStream = new FileInputStream(inputFile)
    val handler = new WriteOutContentHandler(-1)
    val metadata = new Metadata()
    val parser = new PDFParser
    val ctx = new ParseContext()
    parser.parse(inputStream, handler, metadata, ctx)
    Try(inputStream.close())
    val content = handler.toString
    val cleanedContent = content
    cleanedContent
  }

  def getFilesFromDir(dir: String): List[String] = {
    val filesList = new File(dir).listFiles.toList
    //filesList.map { file => getContent(file.getPath) }
     val list = collection.mutable.ListBuffer[String]()
    for (i <- filesList) {
     list.append(getContent(i.getPath))
    }
    list.toList

  }


}




