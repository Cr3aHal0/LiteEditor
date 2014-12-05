package command
import data.Buffer
import data.Clipboard
import data.BufferHistory

class Paste(buffer: Buffer) extends Command
{
  
  
  
  override def execute
  {
    if(!Clipboard.isEmpty)
    {
      //Add the content of the clipboard to the cursor position in the text buffer
      buffer.addStringAt(Clipboard.getContent, buffer.getCursorPosition)
      BufferHistory.addBuffer(buffer)
      printBuffer(buffer)
      
    }else
    {
      println("Clipboard is empty")
    }  
    
    
  }
}