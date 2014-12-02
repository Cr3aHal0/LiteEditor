package command
import data.Buffer
import data.BufferHistory
import data.Clipboard


class Erase(buffer: Buffer) extends Command
{
	override def execute
	{
  
	  buffer.setText(buffer.getText.substring(0, buffer.getCursorPosition)+buffer.getText.substring(buffer.getCursorPosition+1, buffer.getText.length()))
    BufferHistory.addBuffer(buffer)
	}
}