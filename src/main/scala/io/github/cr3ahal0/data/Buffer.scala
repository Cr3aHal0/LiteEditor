package data

class Buffer {
	
  var text : String = ""
  var positionCursor : Integer = 0
  
  //Add a string to the buffer
  def addString(string: String)
  {
    text += text+string
  }
  
  //Add one character to the buffer
  def addChar(char: Char)
  {
    text += text+char
  }
  
  //Remove the character previous the cursor position
  def removePreviousChar(cursorPosition: Integer)
  {
    
  }
  
  def removePreviousWord(cursorPosition: Integer)
  {
    
  }
  
  
  
  
}