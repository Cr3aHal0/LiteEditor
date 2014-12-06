package io.github.cr3ahal0.data
import org.scalatest._
import data.Buffer
import data.BufferHistory



class TestBufferHistory extends FlatSpec{

  
  "BufferHistory state" should "be as expected" in {
    
   val buffer1 : Buffer = new Buffer
   val buffer2 : Buffer = new Buffer
   buffer1.setText("buffer1")
   buffer2.setText("buffer2")
   
   BufferHistory.addBuffer(buffer1)
   BufferHistory.addBuffer(buffer2)
   
   BufferHistory.getPreviousState(buffer2)
   
   assert(buffer2.getText == "buffer1")
   
   BufferHistory.getPreviousState(buffer2)
   assert(buffer2.getText == s"")
   
   BufferHistory.getNextState(buffer2)
   assert(buffer2.getText == "buffer1")
   
   BufferHistory.getNextState(buffer2)
   assert(buffer2.getText == "buffer2")
   
   
   
   
   
  
    
    
  }
  
  
}