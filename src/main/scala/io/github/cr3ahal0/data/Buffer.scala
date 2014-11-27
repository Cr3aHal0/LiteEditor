package data

class Buffer {
	
  private var text : String = ""
  private var cursorPosition : Int = 0
  private var history = BufferHistory
  
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
    BufferHistory.addBuffer(this)
  }
  
  //Add a string to the buffer at a position
  def addStringAt(string: String, cursorPosition: Int)
  {
    text = text.substring(0, cursorPosition)+string+text.substring(cursorPosition, text.length());
    BufferHistory.addBuffer(this)
  }
  
  
  //Add a char to the buffer at a position
  def addCharAt(char: Char, cursorPosition: Int)
  {
    text = text.substring(0, cursorPosition)+char+text.substring(cursorPosition, text.length());
    BufferHistory.addBuffer(this)
  }
  
  

  
}

