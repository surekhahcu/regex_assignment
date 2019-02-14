package edu.hcu.regex

import org.scalatest.FunSuite

class PdfCleanerTest extends FunSuite {

  test("Pdf cleaning") {
    val contentToBeClean = PdfCleaner.clean("iPhone 4S Leveling Off? iPhone has clearly crushed our pre-4S launch expectations for units sold. We are adding yet another 4MM units for F3Q12 to our model, in addition to the 5MM increase for F2Q12 outlined above.\nHowever, a natural decline in iPhone 4S sales (now about 6 months into its lifecycle) has set in over the past few weeks in our latest checks - especially\nin the U.S. As a result, we would not be surprised if 4S\n\n Apple \n\n April 17, 2012 2 \n\nCowen AAPL Estimate Changes versus Consensus \n \n\nIn USD\n\nRevenue ($B) $38.0 $35.2 $32.5 $36.3 $38.5 $36.0 $37.2 $163.3 $158.1 $160.5\n\nEPS $10.32 $9.59 $8.70 $9.87 $10.13 $9.49 $9.86 $44.88 $43.50 $44.18")
    val cleanedContent = "However, a natural decline in iPhone 4S sales (now about 6 months into its lifecycle) has set in over the past few weeks in our latest checks - especially\nin the U.S. As a result, we would not be surprised if 4S1\n Apple1\n April 17, 2012 21\nCowen AAPL Estimate Changes versus Consensus1\nIn USD1"
    assert(contentToBeClean === cleanedContent)
  }

}
