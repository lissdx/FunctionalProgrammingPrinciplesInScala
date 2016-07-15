import scala.math._

def isGoodEnogh(guess: Double, x: Double): Boolean = {
  abs( guess * guess - x ) / x < 0.001
}

def improve(guess: Double, x: Double): Double = {
  (guess + x/guess)/2
}

def sqrIter(guess: Double, x: Double ): Double =
if( isGoodEnogh( guess, x ))
  guess
else
  sqrIter( improve(guess, x ), x)

def sqrt(x: Double ) = sqrIter(1.0, x)

sqrt( 2 )
sqrt( 4 )
sqrt( 1e-6 )
sqrt( 1e60 )