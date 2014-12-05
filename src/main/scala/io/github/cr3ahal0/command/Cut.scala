package command

import data.Buffer
import data.Clipboard
import data.BufferHistory
import data.Selection

class Cut(buffer: Buffer, selection : Selection) extends Command
{

  override def execute
  {
    //Stock the selected part of the buffer in the clipboard
    Clipboard.setContent((buffer.getText).substring(selection.getStartingPosition, selection.getCurrentPosition))
    //The buffer become a new buffer without the selection which we have cut
    buffer.setText(buffer.getText.substring(0, selection.getStartingPosition)+buffer.getText.substring(selection.getCurrentPosition, buffer.getLength))    
    BufferHistory.addBuffer(buffer)
    printBuffer(buffer)
    println("Content of clipboard : "+Clipboard.getContent)
  }
  
}