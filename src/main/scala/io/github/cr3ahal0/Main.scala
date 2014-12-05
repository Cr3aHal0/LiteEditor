
import data.Buffer
import data.Clipboard
import data.Selection
import command.Copy
import command.Cut
import command.Paste
import command.Erase
import command.Write
import command.Undo
import command.Redo
import scala.util.matching.Regex

object Main {


	var buffer : Buffer = new Buffer
  var choix : String = "0"
  

	def menu()
	{
    var selection : Selection = new Selection(0)
    var reg : Regex = new Regex("(([^0-9+]))")

		while(choix.toInt != 14)
    { 
      
		  while((reg findAllIn choix).toList.size > 0 || choix.toInt < 1  || choix.toInt > 14 )
		  { 
        println()
        println()
  			println("Bienvenue dans le projet scala LiteEditor")
  			println("Veuillez choisir une option du menu")
  			println("[1] Ajouter une lettre au buffer")
  			println("[2] Supprimer une lettre du buffer (supprime par défaut le dernier caractere du mot)")
  			println("[3] Copier une partie du buffer")
  			println("[4] Couper une partie du buffer")
  			println("[5] Coller le contenu du presse papier")
        println("[6] Positionner le curseur")
        println("[7] Sélectionner + déplacer le curseur vers la droite")
        println("[8] Sélectionner + déplacer le curseur vers la gauche")
        println("[9] Tout sélectionner jusqu'au début du document")
        println("[10] Tout sélectionner jusqu'à la fin du document")
        println("[11] Visualiser le contenu de la sélection")
        println("[12] Retour en avant")
        println("[13] Retour en arriere")
  			println("[14] Quitter l'editeur")
  			println("Choix : ")
        choix = readLine()
      }

      
      
		  var string : String = ""
      var position : String = ""
      
		  choix match
		  {
        
			  
  			case "1" => 
  			print("Entrez une lettre ou phrase à ajouter au buffer : ")
  			string = readLine
        var write : Write = new Write(buffer, string, buffer.getCursorPosition)
        write.execute
        choix = "0"
  			
  			
  			case "2" =>
  			var erase : Erase = new Erase(buffer, buffer.getCursorPosition)
        println(buffer.getCursorPosition)
  			erase.execute
        choix = "0"
        
        case "3" => 
        var copy : Copy = new Copy(buffer, selection)
        copy.execute()
        choix = "0"
        
        case "4" => 
        var cut : Cut = new Cut(buffer, selection)
        cut.execute()
        choix = "0"
          
        case "5" => 
        position = readLine
        if(((reg findAllIn position).toList.size > 0))
        {
          println("ERREUR DE FORMAT")
        }
        else
        {
          var paste : Paste = new Paste(buffer)
          paste.execute()
        }
        choix = "0"
        
        
        case "6" => println("Position du curseur : ")
        position = readLine
        if((reg findAllIn position).toList.size > 0)
        {
          println("ERREUR DE FORMAT")
        }
        else 
        {
          buffer.setCursorPosition(position.toInt)
          selection.setStartingPosition(position.toInt)
          buffer.printBuffer()
        }
        
        choix = "0"
        
        case "7" => selection.expandRight(buffer.getText)
        choix = "0"
        
        case "8" => selection.expandLeft(buffer.getText)
        choix = "0"
        
        case "9" => selection.expandLeftCorner(buffer.getText)
        choix = "0"
        
        case "10" => selection.expandRightCorner(buffer.getText)
        choix = "0"
        
        case "11" => println("Contenu de la sélection : "+ selection.getText)
        choix = "0"
        
        case "12" => val redo : Redo = new Redo(buffer)
        redo.execute
        println("Contenu du buffer à l'instant t+1 : "+buffer.getText)
        choix = "0"
        
        case "13" => val undo : Undo = new Undo(buffer)
        undo.execute
        println("Contenu du buffer à l'instant t-1 : "+buffer.getText)
        choix = "0"
        
  			case "14" => println("***************** FIN DU PROGRAMME! *****************")




		  }
	  }
  } 
	


  def main(args: Array[String]){


  	menu


	
	
  }




}