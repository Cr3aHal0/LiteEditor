package data

class Buffer (aName : String) {
	
  private var name : String = aName;
  private var text : String = ""
  private var cursorPosition : Int = 0
  private val history = BufferHistory
  private val cursor = new Cursor(0)
  
  def getName = name
  def getText = text
  def getLength = text.length()
  def getCursorPosition = cursor.getPosition
  def getHistory = history
  
  /**
   * Define the current text value of the buffer
   * 
   * @param text the value of the buffer
   */
  def setText(text: String){
    this.text = text
  }

  /**
   * Define the virtual width (cols) of the buffer
   * 
   * @param width the specific width of the buffer
   */
  def setBufferWidth(width : Integer) 
  {
    Buffer.setWidth(width)
  }
  
  /**
   * Returns the current buffer' width
   * 
   * @return Integer the current buffer width
   */
  def getBufferWidth() : Integer = {
    return Buffer.getWidth()  
  }
  
  /**
   * 
   */
  def checkCursorPosition() {
	  cursor.setPosition(cursor.getPosition, this) 
  }
  
  /**
   * Set the cursor position
   * 
   * @param position the position in the file you want to set it
   */
  def setCursorPosition(position : Int)
  {
    if (position > this.getLength) {
      cursor.setPosition(this.getLength, this)
    }
    else
    {
      cursor.setPosition(position, this)
    }
  }
  
  /**
   * Add a string to the buffer at the current cursor position
   * 
   * @param string the string we want to append
   */
  def addString(string: String) 
  {
    checkCursorPosition()
    text = text.substring(0, cursor.getPosition)+string+text.substring(cursor.getPosition, text.length());
    cursor.movePosition(string.length(), this);
  }
  
  /**
   * Add the string to the buffer at a specific position (cursor aside)
   * 
   * @param string the string we want to add
   * @param cursorPosition the place where we want to put the new string at
   */
  def addStringAt(string: String, cursorPosition: Int)
  {
    text = text.substring(0, cursorPosition)+string+text.substring(cursorPosition, text.length());
    BufferHistory.addBuffer(this)
  }  
  
  /**
   * Return the previous state of the buffer
   * 
   * @return Buffer the previous buffer state
   */
  def getPreviousState : Buffer =
  {
    history.getPreviousState(this)
    return this
  }
  
  /**
   * Return the following state of the buffer
   * 
   * @return Buffer the next buffer state
   */
  def getNextState : Buffer =
  {
    history.getNextState(this)
    return this
  }
  
  /**
   * Print the current buffer
   */
  def printBuffer()
  {
    println(cursor.setCursorAt(getCursorPosition, this))
  }
  
}

/**
 * Buffer static members
 */
object Buffer {
  
    /**
     * The virtual width of a buffer
     */
    private var WIDTH = 100;
    
    /**
     * Define the new buffer width
     * 
     * @param width the new width
     */
    def setWidth(width : Integer) {
      WIDTH = width
    }
    
    /**
     * Return the current virtual width of the buffers
     * 
     * @return the current width of the buffers
     */
    def getWidth() : Integer = {
      return WIDTH
    }
}