package edu.hcu.regex

import org.scalatest.FunSuite

class PdfToTextTest extends FunSuite {


  test("content of pdfs ") {
    val content = PdfToText.getContent("/home/surekha/testing/testdata.pdf/").trim
    val expectedContent = "Some F2Q12 iPhone Upside Likely. Apple guided to F2Q12 revenue and EPS of $32.5B/$8.50 on \nweaker q/q gross margins of ~42% (-270 bpsq/q). The GM decline reflects higher expected \ncomponent costs (due to HDDshortages), a strengthening dollar and loss of leverage (no expected \none-timers, the return to a 13-week quarter). We are raising our F2Q12 iPhoneunit estimates to \n32MM from 27MM, and believe that number may well be~4-6MM light of the actual iPhones sold \nduring the quarter. Our checks show iPhone sales were down ~20% q/q domestically in C1Q12, but \nthe q/q U.S. decline was at least partially offset by increased international sales (e.g. China). Record\nsales of the new iPad post-launch in mid-March (~3MM first weekend) point to strong revenue for \nthat product family.\n\niPhone 4S Leveling Off? iPhone has clearly crushed our pre-4S launch\nexpectations for units sold. We are adding yet another 4MM units for F3Q12\nto our model, in addition to the 5MM increase for F2Q12 outlined above.\nHowever, a natural decline in iPhone 4S sales (now about 6 months into its\nlifecycle) has set in over the past few weeks in our latest checks - especially\nin the U.S. As a result, we would not be surprised if 4S\n\n Apple \n\n April 17, 2012 2 \n\nCowen AAPL Estimate Changes versus Consensus \n \n\nIn USD\n\nRevenue ($B) $38.0 $35.2 $32.5 $36.3 $38.5 $36.0 $37.2 $163.3 $158.1 $160.5\n\nEPS $10.32 $9.59 $8.70 $9.87 $10.13 $9.49 $9.86 $44.88 $43.50 $44.18\n\nGross Margin 42.9% 42.9% 42.0% 42.7% 42.3% 42.3% 42.1% 43.3% 43.3% 42.9%\n\nMac Units, MM 4.7 4.7 n/a n/a 4.8 4.8 n/a 19.6 19.6 n/a\n\niPhone Units, MM 32.0 27.0 n/a n/a 28.0 24.0 n/a 126.5 117.5 n/a\n\niPad Units, MM 12.7 12.7 n/a n/a 18.5 18.5 n/a 65.3 65.3 n/a\n\niPod Units, MM 7.0 8.3 n/a n/a 6.4 7.2 n/a 35.1 37.2 n/a\n\nFY12E\n\nCons.Cowen (New)\nCowen \n(Old)\n\nF2Q12E (Mar.)\n\nCowen \n(New)\n\nCowen \n(Old) Cons.Guidance\n\nF3Q12E (June)\n\nCowen \n(New)\n\nCowen \n(Old) Cons."
    assert(content == expectedContent)
  }


 /*   test("pdf files content from directory") {
      val result = PdfToText.getFilesFromDir("/home/surekha/testing/")
      val expectedResult=List(" ","Cowen iPad Survey: iPad mini Meets Market's Demand For Lower-Priced Tablets")
      assert(result==expectedResult)

    }*/
}


