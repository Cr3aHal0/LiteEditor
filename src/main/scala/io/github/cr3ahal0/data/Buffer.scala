package data

import command.Copy;

class Buffer {
	
  private var text : String = ""
  private var cursorPosition : Int = 0
  
  def Buffer(text: String, cursorPosition: Int){
    this.text = text
    this.cursorPosition = cursorPosition
  }
  
  
  def getText = text
  def getCursorPosition = cursorPosition
  def getLength = text.length()
  
  def setText(text: String){
    this.text = text
  }
  
  def setCursorPosition(position: Int){
    this.cursorPosition = position
  }
  
  def write(string : String)
  {
    text += string
  }
  
  //Add a string to the buffer at a position
  def addStringAt(string: String, cursorPosition: Int)
  {
    text = text.substring(0, cursorPosition)+string+text.substring(cursorPosition, text.length());
  }
  
  
  //Add a char to the buffer at a position
  def addCharAt(char: Char, cursorPosition: Int)
  {
    text = text.substring(0, cursorPosition)+char+text.substring(cursorPosition, text.length());
  }
  
  //Remove the character previous the cursor position
  def removePreviousChar(cursorPosition: Int)
  {
    text = text.substring(0, cursorPosition)+text.substring(cursorPosition+1, text.length())
  }
  

  
}