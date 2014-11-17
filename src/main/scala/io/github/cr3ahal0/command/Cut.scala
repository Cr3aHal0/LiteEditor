package command

import data.Buffer
import data.Clipboard

class CutCommand extends Command
{

  def execute(buffer: Buffer, clipboard: Clipboard, position: Integer)
  {
    //Stock the buffer in the clipboard
    clipboard.setContent(buffer)
    clipboard.clear
  }
  
}