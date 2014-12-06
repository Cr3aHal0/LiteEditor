package data

class Cursor (pos:Int){
  
  private var position : Int = pos;
  
  def getPosition : Int = 
  {
    return position;
  }
  
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