val i1 = List(1,3)
val i2 = List(2,4,810)
val one = List("a")
val two = List("a", "b")

for( ii <- i1; aa <- i2 ) yield (ii, aa)

i2 updated( 1, 222)
val i3 = i2

def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List.empty
  //case y :: ys => xs.take( xs.length - 1 )
  case y :: ys => y :: init( ys )
}

init( i2 )
init( one )
init( two )
val i4 = i2.take( i2.length - 1 )

def removeAt[T](n: Int, xs: List[T]) = xs.take( n ) ::: xs.drop( n + 1)

//def flatten(xs: List[Any]): List[Any] = xs.redreduceLeft( (l, r) => r match {
//  case List() => l
//  case List(x) => l ++ r
//  case h :: tail => l ::: r
//  case y: Int => "scala.Int"
//})