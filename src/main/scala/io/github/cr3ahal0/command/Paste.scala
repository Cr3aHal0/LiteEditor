package command
import data.Buffer
import data.Clipboard

class Paste(buffer: Buffer, clipboard: Clipboard, position: Integer) extends Command
{
  
  
  
  override def execute
  {
    if(clipboard.getContent != "")
    {
      //Add the content of the clipboard to the cursor position in the text buffer
      buffer.addStringAt(clipboard.getContent, position)
      println("New buffer : "+buffer.getText)
      
    }else
    {
      println("Clipboard is empty")
    }  
    
    
  }
}