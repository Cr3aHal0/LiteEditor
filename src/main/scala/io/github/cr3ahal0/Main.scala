
import data.Buffer
import data.Clipboard
import data.Selection

import command.Copy
import command.Cut
import command.Paste
import command.Erase
import command.Write

object Main {


	var buffer : Buffer = new Buffer
  var choix : Int = 0
  

	/*Tant que l'utilisateur ne quitte pas le menu (6) il reste dedans)*/


	def menu()
	{
    var selection : Selection = new Selection(0)

		while(choix != 12)
    { 
		  while(choix < 1  || choix > 12)
		  { 
        println()
        println()
  			println("Bienvenue dans le projet scala LiteEditor")
  			println("Veuillez choisir une option du menu")
  			println("[1] Ajouter une lettre au buffer")
  			println("[2] Supprimer une lettre du buffer")
  			println("[3] Copier une partie du buffer")
  			println("[4] Couper une partie du buffer")
  			println("[5] Coller le contenu du presse papier")
        println("[6] Positionner le curseur")
        println("[7] Sélectionner + déplacer le curseur vers la droite")
        println("[8] Sélectionner + déplacer le curseur vers la gauche")
        println("[9] Tout sélectionner jusqu'au début du document")
        println("[10] Tout sélectionner jusqu'à la fin du document")
        println("[11] Visualiser le contenu de la sélection")
  			println("[12] Quitter l'editeur")
  			println("Choix : ")
  			choix = readInt()
		  }

		  var string : String = ""
		  var position : Int = 0
      var positionDebut : Int = 0
      var positionFin : Int = 0
		  choix match
		  {

			
				/*A changer : faire tout passer par les commandes*/
  			case 1 => 
  			print("Entrez une lettre ou phrase à ajouter au buffer : ")
  			string = readLine()
        var write : Write = new Write(buffer, string)
  			buffer.write(string)
  			println(buffer.getText)
        choix = 0
  			
  			
  			case 2 => println("Donnez la position du caractere à effacer")
  			position = readInt
  			var erase : Erase = new Erase(buffer, position)
  			erase.execute
        
        choix = 0
  
        case 3 => println("Position du curseur debut :")
        positionDebut = readInt
        println("Position du curseur fin :")        
        positionFin = readInt
        var copy : Copy = new Copy(buffer, positionDebut, positionFin)
        copy.execute()
        choix = 0
        
        case 4 => println("Position du curseur debut :")
        positionDebut = readInt
        println("Position du curseur fin :")        
        positionFin = readInt
        var cut : Cut = new Cut(buffer, positionDebut, positionFin)
        cut.execute()
        println(buffer.getText)
        choix = 0
          
        case 5 => println("Position du curseur : ")
        position = readInt
        var paste : Paste = new Paste(buffer, position)
        paste.execute()
        choix = 0
        
        case 6 => println("Position du curseur : ")
        position = readInt
        selection.setStartingPosition(position)
        choix = 0
        
        case 7 => selection.expandRight(buffer.getText)
        choix = 0
        
        case 8 => selection.expandLeft(buffer.getText)
        choix = 0
        
        case 9 => selection.expandLeftCorner(buffer.getText)
        choix = 0
        
        case 10 => selection.expandRightCorner(buffer.getText)
        choix = 0
        
        case 11 => println("Contenu de la sélection : "+ selection.getText)
        choix = 0
        
  			case 12 => println("***************** FIN DU PROGRAMME! *****************")




		  }
	  }
  } 
	


  def main(args: Array[String]){


  	menu


	
	
  }




}