package data

class Cursor (pos:Int){
  
  /**
   * The current position of the cursor
   */
  private var position : Int = pos;
  
  /**
   * Return the current position of the cursor
   * 
   * @return position the current cursor position
   */
  def getPosition : Int = 
  {
    return position;
  }
  
  /**
   * Define the new position of the cursor
   * 
   * @param pos the new position
   * @param buffer the current Buffer 
   */
  def setPosition(pos : Int, buffer: Buffer) =
  {
    if(pos > buffer.getLength)
    {
      position = buffer.getLength
    }
    else {
      position = pos;
    }
  }
  
  /**
   * Move the cursor from several cols
   * 
   * @param pos the amount of cols we want to jump
   * @param buffer the current buffer
   */
  def movePosition(pos : Int, buffer: Buffer) = 
  {
    
     if(pos+position > buffer.getLength)
     {
       position = buffer.getLength
     }
     else
     {
       position += pos
     }
    
  }
  
  /**
   * Define the new cursor position
   * 
   * @deprecated for test purpose ONLY !
   * @see for test purpose ONLY !
   * 
   * @param pos the new position of the cursor
   * @param buffer the current buffer
   */
  def setCursorAt(pos: Int, buffer: Buffer) : String = 
  {
    var position : Int = pos
    if(buffer.getLength == 0){
      return "|"
    }
    else
    {
      if (position > buffer.getLength) {
        position = buffer.getLength
      }
      return buffer.getText.substring(0, position)+"|"+buffer.getText.substring(position, buffer.getLength)
    }  
    
  }
}