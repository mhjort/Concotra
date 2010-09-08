package concotra

import scala.io.Source
import java.io._

object Db {
  private val dbDir = "db"

  private def nextId = new File(dbDir).listFiles.size + 1

  private def initialize { 
    val db = new File(dbDir)
    if (!db.exists) db.mkdir
  }
 
  def readEntry(id : String) = {
    initialize
    Source.fromFile(dbDir + "/" + id).mkString
  }

  def newEntry(contents : String) = {
    initialize
    val id = nextId
    val writer = new FileWriter(dbDir + "/" + id)
    writer.write(contents)
    writer.flush
    id
  }

  def cleanUp() {
    initialize
    new File("db").listFiles.foreach(f => f.delete)
  }
}
