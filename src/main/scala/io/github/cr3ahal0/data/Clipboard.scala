package data

object Clipboard {

  private var content : String = ""
  
  
  def setContent(string: String)
  {
    content = string
  }
  
  def getContent = content
  
  def clear = content = ""
  
  
  def isEmpty : Boolean = {
    return (content == "")
    
  }
  
}


