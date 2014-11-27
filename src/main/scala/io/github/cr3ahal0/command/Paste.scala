package command
import data.Buffer
import data.Clipboard

class Paste(buffer: Buffer, position: Integer) extends Command
{
  
  
  
  override def execute
  {
    if(!Clipboard.isEmpty)
    {
      //Add the content of the clipboard to the cursor position in the text buffer
      buffer.addStringAt(Clipboard.getContent, position)
      println("New buffer : "+buffer.getText)
      
    }else
    {
      println("Clipboard is empty")
    }  
    
    
  }
}