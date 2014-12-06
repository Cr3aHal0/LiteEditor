package io.github.cr3ahal0.data

import org.scalatest._
import data.Clipboard



class TestClipboard extends FlatSpec{

  
  "Clipboard creation" should "be as expected" in {
    
    assert(Clipboard.getContent=="")
    assert(Clipboard.isEmpty == true)
    
    Clipboard.setContent("toto")
    
    assert(Clipboard.getContent=="toto")
    assert(Clipboard.isEmpty == false)
    
    
  }
  
  
}