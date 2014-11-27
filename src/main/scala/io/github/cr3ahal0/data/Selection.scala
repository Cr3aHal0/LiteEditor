package data

import scala.util.matching.Regex
import java.util.ArrayList;

class Selection (start : Int) {
	
  private var value : String = ""
  private var startingPosition : Int = start
  private var currentPosition : Int = start;
  
  def getText = this.value
  def getStartingPosition = this.startingPosition
  def getCurrentPosition = this.currentPosition
  def getLength = value.length()
  
  def setStartingPosition(position : Int) {
    this.value = ""
    this.startingPosition = position
    this.currentPosition = position
  }
  
  //Expand the current selection to the left until the next special char
  //including space
  def expandLeft(string: String)
  {
    var reg : Regex = new Regex("[\\?\\!,.'\\-\\s]")
    var i : Int = currentPosition
    
    while (((reg findAllIn string.charAt(i).toString()).toList.size > 0)) {
      i = i - 1  
    }
    
    while (i > 0 && ((reg findAllIn string.charAt(i).toString()).toList.size > 0)) {
      i = i - 1
    }
    
    currentPosition = i
    if (currentPosition < startingPosition) {
      value = string.substring(currentPosition, startingPosition)
    }
    else
    {
      value = string.substring(startingPosition, currentPosition)
    }
  }
  
  //Expand the current selection to the right until next special char
  //including space
  def expandRight(string: String) 
  {
    var reg : Regex = new Regex("[\\?\\!,.'\\-\\s]")
    var i : Int = currentPosition
    
    while (((reg findAllIn string.charAt(i).toString()).toList.size > 0)) {
      i = i + 1  
    }
    
    while (i < string.length()-1 && ((reg findAllIn string.charAt(i).toString()).toList.size == 0)) {
      i = i + 1
    }
    
    currentPosition = i
    if (currentPosition < startingPosition) {
      value = string.substring(currentPosition, startingPosition)
    }
    else
    {
      value = string.substring(startingPosition, currentPosition+1)
    }    
  }
  
  def expandRightCorner(string: String) {
    value = string.substring(startingPosition, string.length())
  }
  
  def expandLeftCorner(string : String) {
    value = string.substring(0, startingPosition)
  }
  
}