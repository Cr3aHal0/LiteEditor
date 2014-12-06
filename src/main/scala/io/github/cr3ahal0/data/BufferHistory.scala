package data
import java.util.ArrayList;

object BufferHistory 
{

  private var listBufferState : ArrayList[String] = new ArrayList
  private var currentIndex : Integer = 0;
  
  listBufferState.add("")
  
  /**
   * Add an element to the beginning of the list
   * @param b The buffer state we have to record
   */
  def addBuffer(b: Buffer)
  {
    listBufferState.add(b.getText)
    currentIndex = currentIndex + 1
  } 
  
  /**
   * Retrieve the previous state of a buffer
   * 
   * @param buffer the targeted buffer to restore
   */
  def getPreviousState(buffer : Buffer) {
    if (currentIndex > 0) {
      buffer.setText(listBufferState.get(currentIndex - 1))
      currentIndex = currentIndex - 1
    }
  }
  
  /**
   * Retrieve the next state of a buffer
   * 
   * @param buffer the targeted buffer
   */
  def getNextState(buffer : Buffer){
    if (currentIndex < listBufferState.size() - 1) {
      buffer.setText(listBufferState.get(currentIndex + 1))
      currentIndex = currentIndex + 1
    }    
  }
  
  /**
   * Restore a buffer at a specific time
   * 
   * @param buffer the current buffer we want to restore
   * @param state the position of the remaining state
   */
  def restoreBuffer(buffer : Buffer, state : Integer) {
    var flag = 0
    if (state < 0) {
      flag = 0
    }
    else if(state > listBufferState.size() - 1) {
      flag = listBufferState.size() - 1
    }
    else
    {
      flag = state
    }
    buffer.setText(listBufferState.get(flag))
    currentIndex = flag
  }
  
  
  
}