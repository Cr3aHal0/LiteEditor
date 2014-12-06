package io.github.cr3ahal0.data
import data.Cursor
import data.Buffer
import org.scalatest.FlatSpec



class TestCursor extends FlatSpec{


	"Cursor position" should "be as expected" in {

		val buffer : Buffer = new Buffer
    buffer.setText("buffer")
    val cursor : Cursor = new Cursor(0)
    
    assert(cursor.setCursorAt(1300, buffer).equals("buffer|"))
    assert(cursor.setCursorAt(1300, buffer).equals("buffer|"))
    assert(cursor.setCursorAt(-200, buffer).equals("|buffer"))
    /*Si on rentre un string dans la position du curseur il va y avoir un erreur
    car la verification d'argument se fait dans le main*/

    


	}



}
