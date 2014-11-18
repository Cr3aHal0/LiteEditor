package data

class Buffer {
	
  private var text : String = ""
  private var cursorPosition : Integer = 0
  
  def Buffer(text: String, cursorPosition: Integer){
    this.text = text
    this.cursorPosition = cursorPosition
  }
  
  
  def getText = text
  def getCursorPosition = cursorPosition
  
  def setText(text: String){
    this.text = text
  }
  
  def setCursorPosition(position: Integer){
    this.cursorPosition = position
  }
  
  //Add a string to the buffer at a position
  def addStringAt(string: String, cursorPosition: Integer)
  {
    text = text.substring(0, cursorPosition)+string+text.substring(cursorPosition, text.length());
  }
  
  
  //Add a char to the buffer at a position
  def addCharAt(char: Char, cursorPosition: Integer)
  {
    text = text.substring(0, cursorPosition)+char+text.substring(cursorPosition, text.length());
  }
  
  //Remove the character previous the cursor position
  def removePreviousChar(cursorPosition: Integer)
  {
    text.substring(0, cursorPosition)+text.substring(cursorPosition+1, text.length())
  }
  
  
  
}