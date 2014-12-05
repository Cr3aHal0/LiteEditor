package command
import data.Buffer
import data.BufferHistory
import data.Clipboard
import data.Selection
import data.Cursor

//Default : delete the previous char from the cursor position
class Erase(buffer: Buffer, cursorPosition : Int) extends Command
{
	
  //Erase the selection in the buffer
  def Erase(buffer: Buffer, selection: Selection)
  {
    buffer.setText("toto")
    BufferHistory.addBuffer(buffer)
  }
  
  override def execute
	{
    //Delete the char previous the cursor position
	  if(buffer.getLength <= 1)
    {
      buffer.setText("")
      println("Impossible de supprimer, Buffer vide")
    }
    if(buffer.getCursorPosition <= 0){
      println("Impossible de supprimer le caractere précédent, position du curseur = 0")
    }
    else
    {
         buffer.setText(buffer.getText.substring(0, cursorPosition-1)+buffer.getText.substring(cursorPosition, buffer.getText.length()))
         //On deplace le curseur a la position -1 car il y a eu suppression de caracteres
         buffer.setCursorPosition(cursorPosition-1)
         println(buffer.getText)    
         BufferHistory.addBuffer(buffer)
    }
   
    
	}
}