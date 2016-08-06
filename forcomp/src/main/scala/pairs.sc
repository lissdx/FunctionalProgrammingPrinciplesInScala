def isPrime( i: Int ) = {
  ( 2 until i ) forall( i % _ != 0 )
}

val n = 7
(( 1 until n ) map ( i => (1 until i ) map ( j => (i, j) ))).flatten
( 1 until n )
.flatMap ( i => (1 until i )
.map ( j => (i, j) ))
.filter( pair => isPrime( pair._1 + pair._2))