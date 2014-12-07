package io.github.cr3ahal0.data

import org.scalatest._
import data.Clipboard



class TestClipboard extends FlatSpec{

  
  "Clipboard creation" should "be have empty content" in {
    
    assert(Clipboard.getContent=="")
    assert(Clipboard.isEmpty == true)
  }  
    
  "Clipboard add content" should "no be empty" in{
    Clipboard.setContent("toto")
    
    assert(Clipboard.getContent=="toto")
    assert(Clipboard.isEmpty == false)
  }  
    
  
  
  
}