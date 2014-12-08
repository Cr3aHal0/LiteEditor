package data
import java.util.ArrayList;
import java.util.HashMap

object BufferHistory 
{

  private var listBuffers : ArrayList[Buffer] = new ArrayList
  private var mapBufferState : HashMap[Buffer, ArrayList[String]] = new HashMap
  private var mapBufferIndexes : HashMap[Buffer, Integer] = new HashMap
  
  
  /**
   * Returns the instance of the targeted buffer
   * If no buffer corresponds with the specified name, returns a new instance of Buffer
   * 
   * @param name the buffer' name
   * @return buf the targeted buffer
   */
  def getBuffer(name : String) : Buffer = {
    var buf : Buffer = null
    var i : Int = 0
    while(i < listBuffers.size() && buf == null) {
      if (name.equals(listBuffers.get(i).getName)) {
        buf = listBuffers.get(i)
      }
    }
    if (buf == null) {
      buf = new Buffer(name)
      var states : ArrayList[String] =  new ArrayList
      states.add("")
      mapBufferState.put(buf, states)
      mapBufferIndexes.put(buf, 0)
    }
    return buf
  }
  
  /**
   * Add an element to the beginning of the list
   * @param b The buffer state we have to record
   */
  def addBuffer(b: Buffer)
  {
    if (mapBufferState.containsKey(b)) {
      //BUG FIX : https://github.com/Cr3aHal0/LiteEditor/issues/2
      var currentPosition = mapBufferIndexes.get(b)
      var bufferStatesSize = mapBufferState.get(b).size();
      if (currentPosition < bufferStatesSize - 1) {
        var i : Int = 0
        for (i <- (currentPosition+1) until bufferStatesSize-1) {
          mapBufferState.get(b).remove(i)
        }
      }
      mapBufferState.get(b).add(b.getText)
      mapBufferIndexes.put(b, currentPosition+1)
    }
  } 
  
  /**
   * Retrieve the previous state of a buffer
   * 
   * @param buffer the targeted buffer to restore
   */
  def getPreviousState(buffer : Buffer) {
    if (mapBufferState.containsKey(buffer)) {
      var currentIndex : Int = mapBufferIndexes.get(buffer)
      if (currentIndex > 0) {
        buffer.setText(mapBufferState.get(buffer).get(currentIndex - 1))
        mapBufferIndexes.put(buffer, mapBufferIndexes.get(buffer)-1)
      }
    }
  }
  
  /**
   * Retrieve the next state of a buffer
   * 
   * @param buffer the targeted buffer
   */
  def getNextState(buffer : Buffer){
    if (mapBufferState.containsKey(buffer)) {
      var currentIndex : Int = mapBufferIndexes.get(buffer)
      if (currentIndex < mapBufferState.get(buffer).size() - 1) {
        buffer.setText(mapBufferState.get(buffer).get(currentIndex + 1))
        mapBufferIndexes.put(buffer, mapBufferIndexes.get(buffer)+1)
      }   
    }
  }
  
  /**
   * Restore a buffer at a specific time
   * 
   * @param buffer the current buffer we want to restore
   * @param state the position of the remaining state
   */
  def restoreBuffer(buffer : Buffer, state : Integer) {
    if (mapBufferState.containsKey(buffer)) {
      var flag = 0
      if (state < 0) {
        flag = 0
      }
      else if(state > mapBufferState.get(buffer).size() - 1) {
        flag = mapBufferState.get(buffer).size() - 1
      }
      else
      {
        flag = state
      }
      buffer.setText(mapBufferState.get(buffer).get(flag))
      mapBufferIndexes.put(buffer, flag)
    }
  }
  
  
  
}