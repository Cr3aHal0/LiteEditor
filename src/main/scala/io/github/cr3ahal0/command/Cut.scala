package command

import data.Buffer
import data.Clipboard
import data.BufferHistory

class Cut(buffer: Buffer, beginPosition: Integer, endPosition: Integer) extends Command
{

  override def execute
  {
    //Stock the selected part of the buffer in the clipboard
    Clipboard.setContent((buffer.getText).substring(beginPosition, endPosition))
    //The buffer become a new buffer without the selection which we have cut
    buffer.setText(buffer.getText.substring(0, beginPosition)+buffer.getText.substring(endPosition, buffer.getLength))    
    BufferHistory.addBuffer(buffer)
    println("New buffer : "+buffer.getText)
    println("Content of clipboard : "+Clipboard.getContent)
  }
  
}