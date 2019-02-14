package edu.hcu.regex

import org.scalatest.FunSuite

class AssignmentTest extends FunSuite {


  val obj = new Assignment


  test("Extracting Email Id ") {
    val result = obj.extractEmail("My name is bob my email is bob@gmail.com")
    val expectResult = "bob@gmail.com"
    assert(result === expectResult)
  }


  test("Extracting non existing Email Id  ") {
    val result = obj.extractEmail("My name is bob my email")
    val expectResult = ""
    assert(result === expectResult)
  }

  test("Extracting Paragraphs") {
    val result = obj.extractPTag(" This is html page 1 <p>This is paragraph 1</p>  This is html page 2 <p>This is paragraph 2 </p>  This is html page3 <p>This is paragraph 3 </p>"
    )
    val expectResult = List(" <p>This is paragraph 1</p>", " <p>This is paragraph 2 </p>", " <p>This is paragraph 3 </p>")

    assert(result === expectResult)
  }

  test("Removing Paragraphs") {
    val result = obj.removePTag("This is html page 1<p>This is paragraph 1</p>This is html page 2<p>This is paragraph 2</p>This is html page 3<p>This is paragraph 3</p>"
    )
    val expectResult = "This is html page 1 This is html page 2 This is html page 3 "

    assert(result === expectResult)
  }


}
