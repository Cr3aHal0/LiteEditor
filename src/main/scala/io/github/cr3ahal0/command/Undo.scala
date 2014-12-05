package command
import data.Buffer
import data.BufferHistory

import data.Clipboard


class Undo(buffer: Buffer) extends Command
{

	override def execute
  {
    buffer.getPreviousState
    printBuffer(buffer)
		//Retourne le buffer a l'instant t-1
	}
}