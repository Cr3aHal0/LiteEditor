package command

import data.Buffer
import data.Clipboard

class Cut(buffer: Buffer, clipboard: Clipboard, beginPosition: Integer, endPosition: Integer) extends Command
{

  override def execute
  {
    //Stock the selected part of the buffer in the clipboard
    clipboard.setContent((buffer.getText).substring(beginPosition, endPosition))
    //The buffer become a new buffer without the selection which we have cut
    buffer.setText(buffer.getText.substring(0, beginPosition)+buffer.getText.substring(endPosition, buffer.getLength))    
    println("New buffer : "+buffer.getText)
    println("Content of clipboard : "+clipboard.getContent)
  }
  
}