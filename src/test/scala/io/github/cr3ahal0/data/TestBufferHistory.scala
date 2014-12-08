package io.github.cr3ahal0.data
import org.scalatest._
import data.Buffer
import data.BufferHistory



class TestBufferHistory extends FlatSpec{

  
  val buffer1 : Buffer = BufferHistory.getBuffer("buffer1")
  val buffer2 : Buffer = BufferHistory.getBuffer("buffer2")
  buffer1.setText("buffer1")
  buffer2.setText("buffer2")

  BufferHistory.addBuffer(buffer1)
  BufferHistory.addBuffer(buffer2)
  buffer2.addStringAt("test2", 0)
  


	"Get previous state from the BufferHistory" should "return the right buffer text" in {
  	
  	BufferHistory.getPreviousState(buffer2)
  	assert(buffer2.getText == "buffer2")
  
	}
  
  "Get previous (again) state from the BufferHistory" should "return empty text in the buffer" in {
    
    BufferHistory.getPreviousState(buffer2)
    assert(buffer2.getText == "")
    BufferHistory.getPreviousState(buffer2)
    assert(buffer2.getText == "")
  }
  

	"Get next state from the BufferHistory" should "return the right buffer text" in {
    
		BufferHistory.getNextState(buffer2)
		assert(buffer2.getText == "buffer2")

  }  
    
  
  "Get next state from the BufferHistory" should "return the intial buffer text" in {
  
		BufferHistory.getNextState(buffer2)
		assert(buffer2.getText == "test2buffer2")


  }







}