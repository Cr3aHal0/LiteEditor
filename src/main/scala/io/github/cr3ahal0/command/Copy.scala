package command
import data.Buffer
import data.Clipboard

class CopyCommand extends Command
{
  
  //var clipboard : Clipboard = 
  
  
  def execute(buffer: Buffer, clipboard: Clipboard, position: Integer)
  {
    clipboard.setContent(buffer)
  }
  

}