package command
import data.Buffer
import data.Clipboard

class Copy(buffer: Buffer, beginPosition: Integer, endPosition: Integer) extends Command
{
  
  
	override def execute()
	{
		//Add the selection of the buffer to the clipboard
		Clipboard.setContent((buffer.getText).substring(beginPosition, endPosition))
    println("Content of clipboard : "+Clipboard.getContent)
	}


}