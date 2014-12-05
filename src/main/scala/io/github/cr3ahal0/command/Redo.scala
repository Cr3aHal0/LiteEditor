package command
import data.Buffer
import data.Clipboard


class Redo(buffer: Buffer) extends Command
{
	//Change the buffer to the next element of the position in the list of bufferHistory
	override def execute
	{
		buffer.getNextState
    printBuffer(buffer)
	}


}