package io.github.cr3ahal0.data

import org.scalatest._
import data.Buffer



class TestBuffer extends FlatSpec{

  
  "Buffer creation" should "be as expected" in {
    
    val buffer : Buffer = new Buffer
    val bufferTest : Buffer = new Buffer
    bufferTest.setText("toto")
    
    buffer.addString(" test ")
    assert(buffer.getLength == 6)
    assert(buffer.getCursorPosition == 6)
    buffer.addString("toto")
    //assert(buffer.getPreviousState.equals(bufferTest))
    
   
  
    
    
  }
  
  
}