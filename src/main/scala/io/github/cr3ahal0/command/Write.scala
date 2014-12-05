package command
import data.Buffer
import data.BufferHistory
import data.Cursor

//Defaut : ecrit le string a la fin du buffer
class Write(buffer: Buffer, string: String, cursorPosition : Int) extends Command {
 
  
  //Besoin d'ecrire le string a la position du curseur
  
  override def execute(){
    buffer.addString(string)
    println(buffer.getText)
    BufferHistory.addBuffer(buffer)
  }
  
  
}