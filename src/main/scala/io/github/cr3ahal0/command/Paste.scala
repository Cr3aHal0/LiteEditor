package command
import data.Buffer
import data.Clipboard

class PasteCommand extends Command
{
  
  
  
  def execute(buffer: Buffer, clipboard: Clipboard, position: Integer)
  {
    
    //Affiche le contenu du clipboard
    buffer.addString(clipboard.getContent)    
    
  }
}