import scala.collection.immutable.IndexedSeq

/** A word is simply a `String`. */
type Word = String

/** A sentence is a `List` of words. */
type Sentence = List[Word]

/** `Occurrences` is a `List` of pairs of characters and positive integers saying
  *  how often the character appears.
  *  This list is sorted alphabetically w.r.t. to the character in each pair.
  *  All characters in the occurrence list are lowercase.
  *
  *  Any list of pairs of lowercase characters and their frequency which is not sorted
  *  is **not** an occurrence list.
  *
  *  Note: If the frequency of some character is zero, then that character should not be
  *  in the list.
  */
type Occurrences = List[(Char, Int)]


val world=("goooglee")
val e:List[Word] = List("opa", "joppa", "google", "?", "apo")
//val tt:Occurrences = ???
e.flatten.mkString
val ttt:Occurrences = wordOccurrences( world )
val tttt:Occurrences = sentenceOccurrences(e )
def wordOccurrences(w: Word): Occurrences = w.toLowerCase.filter( _.isLetter ).groupBy( x => x).map( tpl => (tpl._1, tpl._2.length) ).toList.sortBy( tpl => tpl._1 )

/** Converts a sentence into its character occurrence list. */
def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences( s.flatten.mkString )

val a = List("ate", "eat", "tea")

val dictionaryByOccurrences: Map[Occurrences, List[Word]] = (a ++ e ).map( w =>  wordOccurrences( w ) -> w ).groupBy( tpl => tpl._1 ).map( tpl => ( tpl._1 -> (tpl._2.map( k => k._2 )).distinct ))

def wordAnagrams(word: Word): List[Word] = {
  dictionaryByOccurrences.getOrElse( wordOccurrences(word), List() )
}

dictionaryByOccurrences.getOrElse( wordOccurrences("poa"), List() )
wordOccurrences("poa")
val poa = wordAnagrams("poa")


//cVal.map( oc => )
//strCombine( "opa" )
//
////ttt.union( ttt ).g
//def strCombine( str: String ): Seq[String] = {
//  combine( str.toCharArray.toList )
//}
val aa = List("1", "2", "3" )
val c1 = combine1(aa)
def combine1(ls: List[String]): Set[List[String]] =
  if( ls isEmpty ) Set(List())
else{
  for {
    split <- 0 to ls.length
    occur <- ls.take( split )
    rest <- combine1( ls.drop( split ))
  } yield (occur) :: rest
}.toSet

val cVal = List(('a', 2), ('b', 2))
def combine(occurrences: Occurrences): Set[Occurrences] =
  if( occurrences isEmpty ) Set(List())
  else{
    for {
      split <- 0 to occurrences.length
      occur <- occurrences.take( split )
      rest <- combine( occurrences.drop( split ))
    } yield (occur) :: rest
  }.toSet
//
//val ccc = combine( cVal )
//
//
//def allChOcc( aO:(Char, Int) )  =
//  (for{
//    i <- 1 to aO._2
//  } yield ( aO._1, i )).toList
//
//allChOcc(('a', 2))

cVal.drop( 0 )
cVal.drop( 1 )
def com2(occurrences: Occurrences): List[Occurrences] = occurrences match {
  case List() => List(Nil)
  case (c, n) :: others =>
    val tails = com2(others)
    tails ::: (for {
      j <- tails
      i <- 1 to n
    } yield (c, i) :: j)
}
val com2Val = com2( cVal )

//def allChOcc( aO:(Char, Int) ): Occurrences  =
//  (for{
//    i <- 1 to aO._2
//  } yield ( aO._1, i )).toList

//allExtend( cVal )
//
//def allExtend(occurrences: Occurrences ): List[Occurrences] = {
//  occurrences.map( ocr => allChOcc( ocr ))
//}

val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
val r = List(('r', 1))
r.indexOf( lard(0) )
r.indexOf( lard(3) )
val lard1 = lard.filter( tpl => r.indexOf( tpl ) >= 0 && r(r.indexOf( tpl ))._2 <= tpl._2 )
subtract(lard, r)
def subtract(x: Occurrences, y: Occurrences): Occurrences =
  x.filter( tpl =>{ val ind = y.indexOf( tpl ); !(ind >= 0 && y(ind)._2 <= tpl._2 ) })