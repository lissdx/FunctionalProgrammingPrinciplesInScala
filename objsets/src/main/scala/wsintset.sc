abstract class WSintSet {
  def incl(x: Int): WSintSet
  def contains(x: Int): Boolean
  def union(set: WSintSet): WSintSet
}

object WSintSetEmpty extends WSintSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): WSintSet = {
    new WSintSetNonEmpty(x, WSintSetEmpty, WSintSetEmpty)
  }
  override def union(set: WSintSet): WSintSet = set

  override def toString = "."
}

class WSintSetNonEmpty(elem: Int, left: WSintSet, right: WSintSet)
  extends WSintSet {

  def contains(x: Int): Boolean = {
    if (x < elem)
      left contains (x)
    else if (x > elem)
      right contains (x)
    else
      true
  }

  def incl(x: Int): WSintSet = {
    if (x < elem)
      new WSintSetNonEmpty(elem, left incl x, right)
    else if (x > elem)
      new WSintSetNonEmpty(elem, left, right incl x)
    else
      this
  }

  override def union(other: WSintSet): WSintSet = {
    (( left union right ) union other) incl( elem )
  }

  override def toString = "{" + left + elem + right + "}"
}



val t1 = new WSintSetNonEmpty(3, WSintSetEmpty, WSintSetEmpty )
val t2 = t1 incl( 4 )