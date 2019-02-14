package edu.hcu.regex

import scala.util.matching.Regex


class Assignment {

  def extractEmail(str: String): String = {
    // val regex= "[a-z0-9]+\\@[a-z]+\\.[a-z]+".r
    val regex = new Regex("[a-z0-9]+\\@[a-z]+\\.[a-z]+")
    regex.findFirstIn(str).getOrElse("")
  }


  def extractPTag(html: String): List[String] = {
    val regex = new Regex(" <p>(.*?)<\\/p>")
    val result: Regex.MatchIterator = regex.findAllIn(html)
    result.toList
  }

  def removePTag(html: String): String = {
    html.replaceAll("<p>(.*?)<\\/p>", " ")
  }

}


