package command
import data.Buffer
import data.Clipboard


class Erase(buffer: Buffer, position: Integer) extends Command
{
   override def execute
   {
    buffer.removePreviousChar(position);
  }
}