package data


object BufferHistory 
{

  var listBuffer : List[Buffer] = List()
  
  //Add an element to the begin of the list
  def addBuffer(b: Buffer)
  {
    listBuffer::List(b)
  } 
   
  //
  def clearBuffer()
  {
    
  }
  
  
  
}