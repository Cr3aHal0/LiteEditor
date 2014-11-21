import data.Buffer
import data.Clipboard
import command.Copy
import command.Cut
import command.Paste

object Main {



	var buffer : Buffer = new Buffer
  var clipboard : Clipboard = new Clipboard
	var choix : Int = 0
  

	/*Tant que l'utilisateur ne quitte pas le menu (6) il reste dedans)*/


	def menu()
	{
    
		while(choix != 6)
    { 
		  while(choix < 1  || choix > 6)
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
  			println("[6] Quitter l'editeur")
  			println("Choix : ")
  			choix = readInt()
		  }

		  var string : String = ""
		  var position : Int = 0
      var positionDebut : Int = 0
      var positionFin : Int = 0
		  choix match
		  {

			
			
  			case 1 => 
  			print("Entrez une lettre ou phrase à ajouter au buffer : ")
  			string = readLine()
  			buffer.write(string)
  			println(buffer.getText)
        choix = 0
  			
  			case 2 => println("Donnez la position du caractere à effacer")
  			position = readInt
  			buffer.removePreviousChar(position)
  			println(buffer.getText)
        choix = 0
  
        case 3 => println("Position du curseur debut :")
        positionDebut = readInt
        println("Position du curseur fin :")        
        positionFin = readInt
        var copy : Copy = new Copy(buffer, clipboard, positionDebut, positionFin)
        copy.execute()
        choix = 0
        
        case 3 => println("Position du curseur debut :")
        positionDebut = readInt
        println("Position du curseur fin :")        
        positionFin = readInt
        var copy : Copy = new Copy(buffer, clipboard, positionDebut, positionFin)
        copy.execute()
        choix = 0
        
        case 4 => println("Position du curseur debut :")
        positionDebut = readInt
        println("Position du curseur fin :")        
        positionFin = readInt
        var cut : Cut = new Cut(buffer, clipboard, positionDebut, positionFin)
        cut.execute()
        choix = 0
          
        case 5 => println("Position du curseur : ")
        position = readInt
        var paste : Paste = new Paste(buffer, clipboard, position)
        paste.execute()
        choix = 0
        
  			case 6 => println("***************** FIN DU PROGRAMME! *****************")




		  }
	  }
  } 
	


  def main(args: Array[String]){


  	menu


	
	
  }




}