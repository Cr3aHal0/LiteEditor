package command
import data.Buffer
import data.Clipboard
import data.Selection
import java.util.ArrayList;

class Macro extends Command
{
  private var commandsList : ArrayList[Command] = new ArrayList
  
	override def execute()
	{
    var i : Integer = 0
    for(i <- 0 until commandsList.size()) {
      commandsList.get(i).execute()
    }
	}

  def addCommand(com : Command) {
    commandsList.add(com);
  }

}