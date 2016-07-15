package funsets

object Main extends App {
  import FunSets._
  val setSingle1 = singletonSet(1)
  val setSingle2 = singletonSet(2)
  val setSingle3 = singletonSet(3)
  val setSingle4 = singletonSet(4)
  val setSingle5 = singletonSet(5)
  val set123 = union( union( setSingle1, setSingle2 ), setSingle3)
  val set312 = union( union( setSingle3, setSingle1 ), setSingle2)
  val set145 = union( union( setSingle1, setSingle4 ), setSingle5)
  val set45 = union( setSingle4, setSingle5 )
  println(contains(singletonSet(1), 1))
  printSet( map( set145,  x => x + 100 ))
}
