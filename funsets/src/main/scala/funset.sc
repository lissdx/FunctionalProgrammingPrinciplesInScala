import funsets.FunSets._

val setSingle1 = singletonSet(1)
val setSingle2 = singletonSet(2)
val setSingle3 = singletonSet(3)
val setSingle4 = singletonSet(4)
val setSingle5 = singletonSet(5)
val set123 = union( union( setSingle1, setSingle2 ), setSingle3)
val set312 = union( union( setSingle3, setSingle1 ), setSingle2)
val set145 = union( union( setSingle1, setSingle4 ), setSingle5)
val set45 = union( setSingle4, setSingle5 )

printSet( set123 )
printSet( set312 )
printSet( set145 )
printSet( set45 )
printSet( set123 )

contains( set123, 1 )
contains( set123, 2 )
contains( set123, 3 )
contains( set123, 4 )

printSet( intersect( setSingle1, setSingle1))
printSet( intersect( setSingle1, setSingle2))
printSet( intersect( set123, set145))
printSet( intersect( set45, set145))
printSet( intersect( set123, set312))
printSet( intersect( set123, set123))

printSet( diff( setSingle1, setSingle1))
printSet( diff( setSingle1, setSingle2))
printSet( diff( set123, set145))
printSet( diff( set45, set145))
printSet( diff( set123, set312))
printSet( diff( set123, set45))

filter( setSingle1, x => x > 10)(1)
filter( setSingle1,  x => x < 10)(1)
filter( set123,  x => x < 10)(1)
filter( set123,  x => x < 10)(5)

printSet( filter( setSingle1, x => x > 10))
printSet( filter( setSingle1,  x => x < 10))
printSet( filter( set123,  x => x < 3 ))
printSet( filter( set45,  x => x < 10))
printSet( filter( set123,  x => x < 10))


forall( setSingle1, x => x > 10 )
forall( setSingle1, x => x < 10 )
forall( set145, x => x < 10 )
forall( set145, x => x < 5 )

exists( setSingle1, _ > 10 )
exists( setSingle1, _ < 10 )
exists( set145, _ < 10 )
exists( set145, _ < 3 )
exists( set145, _ > 5 )


printSet( map( setSingle1, x => x ))
printSet( map( set145,  _ + 100 ))
//printSet( map( set123,  _ + 1 ))
//printSet( map( set123,  _ + 100 ))
//
//printSet( map( set123,  _ + 100 ))
