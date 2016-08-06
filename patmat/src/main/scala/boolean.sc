class Leaf(char: Char, weight: Int)
val list = List('a', 'b', 'a', 'c', 'z', 'z', 'z')
val h = list.groupBy(x=>x).map( pair => (pair._1, pair._2.length)).toList
h.sortBy(_._2).map( m => new Leaf( m._1, m._2))
list.take(2)

val l1 = List(("a", 1),("b", 3))
val l2 = List(("a", 3),("c", 4))
val l3 = List(List(1,0,1,1), List(0,0,0,0,0))
val l4 = List(List(0,1,0,0), List(1,0,0,0,0))
(l3 ++ l4).flatten
//List((1,a), (3,b), (3,a), (4,c))
(l1 ++ l2 )
(l1 ++ l2 ).groupBy(_._1).toList.map( tpl => (tpl._1, tpl._2.map(_._2).sum))
//for( (k, v) <- (l1 ++ l2 ).groupBy(_._1).toList) yield (k, v.sum)
val lCh  = List("a", "b", "c")
val lI  = List(1, 2, 3)
for( i <- lI; c <- lCh;  ) yield i