package command
import java.util.HashMap;

object MacrosManager 
{

  private var macrosMap : HashMap[String, Macro] = new HashMap  
  
  //Add an element to the beginning of the list
  def addMacro(name : String, mc : Macro)
  {
    macrosMap.put(name, mc)
  } 
  
  def getMacro(name : String) : Macro = {
    macrosMap.get(name)
  }
  
  def removeMacro(name : String) {
    macrosMap.remove(name)  
  }
  
  def clear() {
    macrosMap.clear()
  }
  
  def listMacros() : HashMap[String,Macro] = {
    return macrosMap
  }
  
  def print() {
    var set = macrosMap.keySet
    var array = set.toArray()
    var str = ""
    var string : Int = 0
    for (string <- 0 until set.size()) {
      println( "#" + string + " : "+ array(string))
    }
  }
  
}