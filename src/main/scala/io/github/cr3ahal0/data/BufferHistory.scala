package data
import java.util.ArrayList;


object BufferHistory 
{

  private var listBufferState : ArrayList[Buffer] = new ArrayList
  
  //Add an element to the begin of the list
  def addBuffer(b: Buffer)
  {
    listBufferState.add(b)
  } 
   
  //
  def clearBuffer()
  {
    
  }
  
  def getLastBufferState()
  {
    
  }
  
  
  def getNextBufferState()
  {
    
  }
  
  
  
}