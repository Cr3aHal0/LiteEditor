package data

class Clipboard {

  private var content : String = ""
  
  def setContent(string: String)
  {
    content = string
  }
  
  def getContent = content
  
  def clear = content = ""
  
}