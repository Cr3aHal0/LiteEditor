package command
import data.Buffer
import data.BufferHistory
import data.Cursor

class Write(buffer: Buffer, string: String) extends Command {
 
  override def execute(){
    buffer.addString(string)
    buffer.setCursorPosition(buffer.getLength)
    BufferHistory.addBuffer(buffer)
  }
  
  
}