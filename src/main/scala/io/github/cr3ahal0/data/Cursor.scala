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
    if(buffer.getLength == 0){
      return "|"
    }
    else
    {
      return buffer.getText.substring(0, pos)+"|"+buffer.getText.substring(pos, buffer.getLength)
    }  
    
  }
}