package data

import scala.util.matching.Regex
import java.util.ArrayList;
import data.Buffer;

/**
 * Selection
 * 
 * Objet visant à manipuler une sélection dans le buffer.
 * 
 * @param start la position initiale de la sélection
 */
class Selection (start : Int) {
	
  private var value : String = ""
  private var startingPosition : Int = start
  private var currentPosition : Int = start;
  
  def getText = this.value
  def getStartingPosition = this.startingPosition
  def getCurrentPosition = this.currentPosition
  def getLength = value.length()
  
  /**
   * Définit la position initiale de la sélection (souvent, la position du curseur)
   * @param position la position initiale de la sélection
   */
  def setStartingPosition(position : Int) {
    this.value = ""
    this.startingPosition = position
    this.currentPosition = position
  }
  
  /**
   * Elargit la sélection courante vers la gauche jusqu'au prochain espace ou caractère spécial
   * @param string le contenu du buffer
   */
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
  
  /**
   * Elargit la sélection courante vers la droite jusqu'au prochain espace ou caractère spécial
   * @param string le contenu du buffer
   */
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
  
  /**
   * Elargit la sélection courante jusqu'à la fin de la ligne actuelle
   * @param string le contenu du buffer
   */
  def expandRightCorner(string: String) {
    var line : Integer = Math.floor(startingPosition / (Buffer.getWidth).toDouble).toInt
    var fin  : Integer = ((line+1) * Buffer.getWidth()) - 1
    if (fin > string.length) {
      fin = string.length
    }
    value = string.substring(startingPosition, fin)
  }
  
  /**
   * Elargit la sélection courante jusqu'au début de la ligne actuelle
   * @param string le contenu du buffer
   */
  def expandLeftCorner(string : String) {
    var line : Integer = Math.ceil(startingPosition / (Buffer.getWidth).toDouble).toInt
    var debut  : Integer = ((line-1) * Buffer.getWidth())
    if (debut < 0) {
      debut = 0
    }
    value = string.substring(debut, startingPosition)
  }
  
}