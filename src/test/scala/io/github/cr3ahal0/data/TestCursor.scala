package io.github.cr3ahal0.data
import data.Cursor
import data.Buffer
import data.BufferHistory
import org.scalatest.FlatSpec



class TestCursor extends FlatSpec{


	val buffer : Buffer = BufferHistory.getBuffer("test")
	buffer.setText("buffer")
	val cursor : Cursor = new Cursor(0)

	/*Si on rentre un string dans la position du curseur il va y avoir un erreur
  car la verification d'argument se fait dans le main*/


  "Move the cursor at the position 1300" should "move the cursor to the ending of the text" in {
	  assert(cursor.setCursorAt(1300, buffer).equals("buffer|"))
  }
  
  "Move the cursor at the position -200" should "move the cursor to the beginning of the text" in {
    assert(cursor.setCursorAt(-200, buffer).equals("|buffer"))
  }  





}




