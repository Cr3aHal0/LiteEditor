package io.github.cr3ahal0.data

import org.scalatest._
import data.Buffer
import data.BufferHistory



class TestBuffer extends FlatSpec{

  
  "Buffer creation" should "be empty and have length = 0" in {
    val buffer : Buffer = BufferHistory.getBuffer("test")
    assert(buffer.getText == "") 
    assert(buffer.getLength == 0)
    
  }   
   
  
  
  "Buffer addString" should "move the cursor to the right location" in {
    val buffer : Buffer = BufferHistory.getBuffer("test")
    
    buffer.addString(" test ")
    assert(buffer.getLength == 6)
    assert(buffer.getCursorPosition == 6)
  }  
   
  
    
    
  
}
  
