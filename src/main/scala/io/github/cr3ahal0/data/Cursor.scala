package data

class Cursor (pos:Int){
  
  private var position : Int = pos;
  
  def getPosition : Int = 
  {
    return position;
  }
  
  def setPosition(pos : Int) =
  {
    position = pos;
  }
  
  def movePosition(pos : Int) = 
  {
    position += pos
    /*
     * if(pos > buffer.getLength)
     *  position = buffer.getLength)
     */
  }
}