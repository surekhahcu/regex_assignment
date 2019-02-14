package edu.hcu.regex

import java.util.regex.Pattern

object PdfCleaner {

  def clean(contentToBeClean: String): String = {
    val regex = "^(?:[^\\n\\d]*\\d){10,}.*$"
    val pattern = Pattern.compile(regex, Pattern.MULTILINE)
    val resultText = pattern.matcher(contentToBeClean).replaceAll("")
    val regex2 = "(?<=\\S)\\s+$"
    val pattern2 = Pattern.compile(regex2, Pattern.MULTILINE)
    pattern2.matcher(resultText).replaceAll("\\1").trim
  }


}
