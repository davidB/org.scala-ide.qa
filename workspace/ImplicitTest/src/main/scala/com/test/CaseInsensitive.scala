package com.test

/** 
 * Used to enable us to easily index objects by string, case insensitive.
 * 
 * Note: this class preserves the case of your string!
 */
case class CaseInsensitive(val _s: String) extends Proxy {
  require( _s != null)
  
  val self = _s.toLowerCase
  override def toString: String = _s
  
  def i = this // convenience implicit conversion
}

object CaseInsensitive {
  implicit def CaseInsensitive2String(c: CaseInsensitive) = if ( c == null ) null else c._s
  implicit def StringToCaseInsensitive(s: String) = CaseInsensitive(s)
  
  def fromString(s: String): Option[CaseInsensitive] = s match {
    case null => None
    case _ => Some(CaseInsensitive(s))
  }
}