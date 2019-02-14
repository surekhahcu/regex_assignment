package edu.hcu.regex

import slick.driver.MySQLDriver.api._

class DBConnection {
  def db = {
    Database.forURL("jdbc:mysql://localhost:3306/regex_assignment",
      driver = "com.mysql.jdbc.Driver",
      user = "root", password = "root")
  }

}
