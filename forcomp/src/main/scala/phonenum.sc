import scala.io.Source

val in = Source.fromURL("""http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt""")
val words = in.getLines.toList filter( word => word forall( _.isLetter ))

val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI",
  '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS",
  '8' -> "TUV", '9' -> "WXYZ")

//val charCode: Map[Char, Char] =
val charCode = mnem.flatMap( tuple =>  tuple._2.map( ch => ( ch, tuple._1 )))

"Java".map( ch => charCode.getOrElse( ch.toUpper, "_")).mkString

def wordCode( word: String ): String =
  word.toUpperCase.map( ch => charCode.getOrElse( ch, "_")).mkString

wordCode("Java")


val wordsForNum: Map[String, Seq[String]] = {
  words groupBy wordCode
}

def encode(number: String ): Set[List[String]] =
  wordsForNum( number )
//words.filter(wrd => wrd.length == "5282".length ).mkString
//words
////  .filter( wrd => ( wrd(0) == mnem((5 + '0').toChar)(0) || wrd(0) == mnem((5 + '0').toChar)(1) || wrd(0) == mnem((5 + '0').toChar)(2) ))
//  .filter( wrd => ( wrd(1) == mnem((2 + '0').toChar)(0) || wrd(1) == mnem((2 + '0').toChar)(1) || wrd(1) == mnem((2 + '0').toChar)(2) )) mkString
////  .filter( wrd => ( wrd(2) == mnem((8 + '0').toChar)(0) || wrd(2) == mnem((8 + '0').toChar)(1) || wrd(2) == mnem((8 + '0').toChar)(2) ))
////  .filter( wrd => ( wrd(3) == mnem((2 + '0').toChar)(0) || wrd(3) == mnem((2 + '0').toChar)(1) || wrd(3) == mnem((2 + '0').toChar)(2) )).mkString
//
//for(
//  ind <- 0 until  "5282".length
//
//) yield ind