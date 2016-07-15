def squere(x: Double) = x * x
def sumOfSquere(x: Double, y: Double) = squere( x ) + squere( y )
def pow( x: Double, y: Int ): Double = {
  if( y == 0 )
    1
  else
    x * pow( x, y - 1)
}

squere( 2 )
squere( 5 + 4 )
squere( squere( 4 ) )
pow(2, 8)

def test(x: Int, y: Int) = x * x

test( 2, 3 )
// 2 * 3 | 6
// 2 * 3 | 6

test( 3 + 4, 8 )
// test( 7, 8 ) | 7 * 7 | 49
// ( 3 + 4 ) * ( 3 + 4 ) | 7 * ( 3 + 4 ) | 7 * 7 | 49
test( 7, 2 * 4 )
// test( 7, 8 ) | 7 * 7 | 49
// 7 * 7 | 49
test( 3 + 4, 2 * 4 )
// test( 7, ( 2 * 4 ) ) | test( 7, 8 ) | 7 * 7 | 49
// (3 + 4) * (3 + 4)    | 7 * (3 + 4)  | 7 * 7 | 49

def loop: Boolean = loop
def x = loop
//val y = loop
def and( x:Boolean, y: => Boolean) = if( x ) y else false
def or( x:Boolean, y: => Boolean) = if( x ) true else y