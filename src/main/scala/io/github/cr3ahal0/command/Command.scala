package command
import data.Buffer

trait Command {
  
  def execute()
  
  def printBuffer(buffer: Buffer)
  {
    buffer.printBuffer()
    println("Taille du buffer :" +buffer.getLength)
  }

}