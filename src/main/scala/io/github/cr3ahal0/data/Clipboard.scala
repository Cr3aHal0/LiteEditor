package data

class Clipboard {

  var content : String = ""
  
  def setContent(b : Buffer)
  {
    content = b.text
  }
  
  def getContent = content
  
  def clear = content = ""
  
}