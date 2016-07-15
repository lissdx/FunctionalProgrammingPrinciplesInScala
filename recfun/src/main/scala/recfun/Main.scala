package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0)
      if (c == 0) 1 else 0
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def balanceHelper(balanceAcc: Int, currentChar: Char, chars: List[Char]): Int = {
      val newBalance = if (currentChar == ')')
        -1 + balanceAcc
      else if (currentChar == '(')
        1 + balanceAcc
      else
        balanceAcc

      if (chars.isEmpty || newBalance < 0)
        newBalance
      else
        balanceHelper(newBalance, chars.head, chars.tail)
    }

    if (chars.isEmpty)
      true
    else
      balanceHelper(0, chars.head, chars.tail) == 0
  }


  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (money < 0 || coins.isEmpty)
      0
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
