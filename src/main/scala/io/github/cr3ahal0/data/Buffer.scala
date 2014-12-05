package data

class Buffer {
	
  private var text : String = ""
  private var cursorPosition : Int = 0
  private val history = BufferHistory
  private val cursor = new Cursor(0)
  
  def getText = text
  def getLength = text.length()
  def getCursorPosition = cursor.getPosition
  def getHistory = history
  
  def setText(text: String){
    this.text = text
  }

  def setBufferWidth(width : Integer) 
  {
    Buffer.setWidth(width)
  }
  
  def getBufferWidth() : Integer = {
    return Buffer.getWidth()  
  }
  
  def setCursorPosition(position : Int)
  {
    cursor.setPosition(position, this)
  }
  
  def addString(string: String) 
  {
    text = text.substring(0, cursor.getPosition)+string+text.substring(cursor.getPosition, text.length());
    cursor.movePosition(string.length(), this);
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
  
  
  def getPreviousState : Buffer =
  {
    history.getPreviousState(this)
    return this
  }
  
  def getNextState : Buffer =
  {
    history.getNextState(this)
    return this
  }
  
  
  def printBuffer()
  {
    println(cursor.setCursorAt(getCursorPosition, this))
  }
  
}

object Buffer {
    private var WIDTH = 100;
    def setWidth(width : Integer) {
      WIDTH = width
    }
    def getWidth() : Integer = {
      return WIDTH
    }
}