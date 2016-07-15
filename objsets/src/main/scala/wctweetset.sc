import objsets.{Empty, Tweet}

val a = new Tweet("a", "aaaaa", 7)
val b = new Tweet("b", "bbbbb", 3)
val f = new Tweet("f", "fffff", 7)
val g = new Tweet("g", "ggggg", 7)
val m = new Tweet("m", "mmmmm", 7)
val k = new Tweet("k", "kkkkk", 5)
val z = new Tweet("z", "zzzzz", 7)
val e = new Tweet("e", "eeeee", 7)
val d = new Tweet("d", "ddddd", 9)
val c = new Tweet("c", "ccccc", 9)

val set1 = new Empty
val set2 = set1.incl(new Tweet("a", "a body", 20))
val set3 = set2.incl(new Tweet("b", "b body", 20))
val setf = set2.incl(new Tweet("f", "f body", 5))
val set4c = set3.incl(c)
val set4d = set3.incl(d)
val set5 = set4c.incl(d)

set1.filter(tw => tw.user == "a")
set2.filter(tw => tw.user == "a")
set3.filter(tw => tw.user == "a")
set5.filter(tw => tw.user == "a")
set5.filter(tw => tw.user == "a" || tw.user == "d")
set5.filter(tw => tw.user == "a" || tw.user == "d" || tw.user == "c")
set5.filter(tw => true )

val s21 = set1.incl( f ).incl( b ).incl( k ).incl( a )
//val s22 = set1.incl( g ).incl( b ).incl( k )
val s23 = set1.incl( g ).incl(a)

(s21 union s23).mostRetweeted
set5.mostRetweeted
s23.filter( tw => tw.retweets > 0 )