val ar = Array(1,2,3,44)
ar map ( _ * 2 )

val str = "Hello10World"
str filter( _.isUpper )
str exists( _.isUpper )
str forall ( _.isUpper )
str forall ( _.isLetterOrDigit )

val pairs = List(1, 2, 3, 4 ) zip List("A", "B", "C", "ZX", "R")
pairs unzip

str flatMap ( List('.', _))
(1 to 3 ) flatMap( x => ( 10 to 15) map( y => ( x, y )))
