package command
import data.Buffer
import data.Clipboard

class Copy(buffer: Buffer, clipboard: Clipboard, beginPosition: Integer, endPosition: Integer) extends Command
{

	override def execute()
	{
		//Add the selection of the buffer to the clipboard
		clipboard.setContent((buffer.getText).substring(beginPosition, endPosition))
	}


}