package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val setSingle1 = singletonSet(1)
    val setSingle2 = singletonSet(2)
    val setSingle3 = singletonSet(3)
    val setSingle4 = singletonSet(4)
    val setSingle5 = singletonSet(5)
    val set123 = union( union( setSingle1, setSingle2 ), setSingle3)
    val set312 = union( union( setSingle3, setSingle1 ), setSingle2)
    val set145 = union( union( setSingle1, setSingle4 ), setSingle5)
    val set45 = union( setSingle4, setSingle5 )
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains all elements of both singletonSet sets") {
    new TestSets {
      val sng1 = intersect( setSingle1, setSingle1)
      assert(contains(sng1, 1), "Intersect 1")
      assert(!contains(sng1, 2), "Intersect 2")
    }
  }

  test("intersect contains all elements of both multiSet sets") {
    new TestSets {
      val sm123 = intersect( set123, set123)
      assert(contains(sm123, 1), "Intersect 1")
      assert(contains(sm123, 2), "Intersect 2")
      assert(contains(sm123, 3), "Intersect 3")
      assert(!contains(sm123, 4), "Intersect 2")
    }
  }

  test("diff contains all elements singletonSet set of all elements of `s` that are not in `t`") {
    new TestSets {
      val sng1 = diff( setSingle1, setSingle1)
      val sng2 = diff( setSingle1, setSingle2)

      assert(!contains(sng1, 1), "diff 1")
      assert(contains(sng2, 1), "diff 2")
    }
  }

  test("diff contains all elements multiSet set of all elements of `s` that are not in `t`") {
    new TestSets {
      val sng23 = diff( set123, set145)
      val sng0 = diff( set45, set145)

      assert(!contains(sng23, 1), "diff 1")
      assert(contains(sng23, 2), "diff 2")
      assert(contains(sng23, 3), "diff 3")
      assert(!contains(sng23, 4), "diff 4")
      assert(!contains(sng23, 5), "diff 5")

      assert(!contains(sng0, 1), "diff 6")
      assert(!contains(sng0, 4), "diff 7")
      assert(!contains(sng0, 5), "diff 8")
    }
  }

  test("filter returns the subset of `s` for which `p` holds") {
    new TestSets {

      val sng0 = filter( set45,  x => x > 10)
      val sng12 = filter( set123,  x => x < 3)

      assert(!contains(sng0, 4), "filter 1")
      assert(!contains(sng0, 5), "filter 2")
      assert(contains(sng12, 1), "filter 3")
      assert(contains(sng12, 2), "filter 4")
      assert(!contains(sng12, 3), "filter 5")

    }
  }

  test("forall Returns whether all bounded integers within `s` satisfy `p`") {
    new TestSets {
      assert(forall( set145, _ < 10 ), "forall 1")
      assert(!forall( set145, _ < 5 ), "forall 2")
    }
  }

  test("exists  a bounded integer within `s` that satisfies `p`.") {
    new TestSets {
      assert(exists( set145, _ < 3 ), "exists 1")
      assert(!exists( set145, _ > 5 ), "exists 2")
    }
  }

  test("map transformed by applying `f` to each element of `s`") {
    new TestSets {

      val sng1 = map( setSingle1,  _ + 100 )
      val sng2 = map( set123,  _ + 1 )

      assert(!contains( sng1, 1 ), "map 1")
      assert(contains( sng1, 101 ), "map 2")
      assert(!contains( sng2, 1 ), "map 3")
      assert(contains( sng2, 2 ), "map 4")
      assert(contains( sng2, 3 ), "map 5")
      assert(contains( sng2, 4 ), "map 6")
    }
  }
}
