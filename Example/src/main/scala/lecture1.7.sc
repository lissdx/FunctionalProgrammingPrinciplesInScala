def gcd(a: Int, b: Int ): Int = if( b == 0) a else gcd(b, a % b )
def facctorial( n: Int ):Int = if( n <= 0 ) 1 else n * facctorial( n - 1)
def facctorialTail( n: Int ):Int =
  {
    def factorial( acc: Int, f: Int): Int ={
      if( f == 0 )
        acc
      else
        factorial( acc * f, f - 1 )
    }

    factorial( 1, n )
  }

gcd( 14, 21)
facctorial( 4 )
facctorialTail( 4 )
facctorial( 7 )
facctorialTail( 7 )
facctorial( 0 )
facctorialTail( 0 )