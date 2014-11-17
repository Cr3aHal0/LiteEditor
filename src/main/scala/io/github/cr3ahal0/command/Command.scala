package command
import data.Buffer
import data.Clipboard

trait Command {
  
  def execute(buffer: Buffer, clipboard: Clipboard, position: Integer)

}