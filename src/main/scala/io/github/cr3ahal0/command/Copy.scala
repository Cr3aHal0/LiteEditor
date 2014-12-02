package command
import data.Buffer
import data.Clipboard
import data.Selection

class Copy(buffer: Buffer, selection : Selection) extends Command
{
  
  
  
  
	override def execute()
	{
		//Add the selection of the buffer to the clipboard
		Clipboard.setContent((buffer.getText).substring(selection.getStartingPosition, selection.getCurrentPosition))
    println("Content of clipboard : "+Clipboard.getContent)
	}


}