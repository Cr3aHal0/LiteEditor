package command
import java.util.HashMap;
import java.util.ArrayList

object MacrosManager 
{

  private var macrosMap : HashMap[String, Macro] = new HashMap  
  
  private var macrosRunning : ArrayList[Macro] = new ArrayList
  
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
  
  def isRunning(name : String) : Boolean = {
    var mac : Macro = MacrosManager.getMacro(name)
    if (mac != null) {
      return macrosRunning.contains(mac)
    }
    return false
  }
  
  def startMacroRecording(name : String) {
    var mac : Macro = MacrosManager.getMacro(name)
    if (mac != null) {
      if (!macrosRunning.contains(mac)) {
        macrosRunning.add(mac)
      }
    }
  }
  
  def stopMacroRecording(name : String) {
    var mac : Macro = MacrosManager.getMacro(name)
    if (mac != null) {
      if (macrosRunning.contains(mac)) {
        macrosRunning.remove(mac)
      }
    }
  }
  
  def visit(com : Command) {
    var mac : Macro = null
    var i : Integer = 0
    for (i <- 0 until macrosRunning.size()) {
      mac = macrosRunning.get(i)
      macrosMap.get(mac.getName).addCommand(com)
    }
    com.execute()
  }
  
}