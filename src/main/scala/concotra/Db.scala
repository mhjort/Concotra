package concotra

import scala.io.Source

class Db {
  private val dbDir = "db"

  def nextId = new java.io.File(dbDir).listFiles.size + 1

  def readEntry(id : String) = {
    Source.fromFile(dbDir + "/" + id).mkString
  }

  def writeEntry(contents : String) = {
    val id = nextId
    val writer = new java.io.FileWriter(dbDir + "/" + nextId)
    writer.write(contents)
    writer.flush
    id
  }
}
