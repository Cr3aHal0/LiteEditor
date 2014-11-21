import data.Buffer
object Main {



	var buffer : Buffer = new Buffer
	var choix : Int = 0

	/*Tant que l'utilisateur ne quitte pas le menu il reste dedans (6)*/


	def menu()
	{
    
		while(choix != 6)
    { 
		  while(choix < 1  || choix > 6)
		  { 
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

		  var char : Char = ' '
		  var position : Int = 0
		  choix match
		  {

			
			
  			case 1 => println("Donnez le caractere a ajouter au buffer")
  			println("Entrez une lettre à ajouter au buffer : ")
  			char = readChar
  			buffer.write(char)
  			println(buffer.getText)
        choix = 0
  			
  			case 2 => println("Donnez la position du caractere à effacer")
  			position = readInt
  			buffer.removePreviousChar(position)
  			println(buffer.getText)
        choix = 0
  
  			case 6 => println("***************** FIN DU PROGRAMME! *****************")




		  }
	  }
  } 
	


  def main(args: Array[String]){


  	menu


	
	
  }




}