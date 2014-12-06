package data

object Clipboard {

  /**
   * Content of the clipboard
   */
  private var content : String = ""
  
  /**
   * Define the content of the clipboard
   * 
   * @param string the content of the clipboard
   */
  def setContent(string: String)
  {
    content = string
  }
  
  /**
   * Return the current content of the clipboard
   * 
   * @return the content of the clipboard
   */
  def getContent = content
  
  /**
   * Clear the clipboard
   */
  def clear = content = ""
  
  /**
   * Return if the clipboard is empty or not
   * 
   * @return Boolean if the clipboard is empty or not
   */
  def isEmpty : Boolean = {
    return (content == "")
  }
  
}


