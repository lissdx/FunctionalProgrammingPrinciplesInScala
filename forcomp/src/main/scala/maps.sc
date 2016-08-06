val
romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalOfCountry = Map( "US" -> "Washington", "Switzerland" -> "Bern" )

capitalOfCountry( "US" )
capitalOfCountry.get( "andora" )
//capitalOfCountry( "andora" )

def showCapital( county: String ) = capitalOfCountry.get( county ) match {
  case Some( capital ) => capital
  case _ => "Not Found"
}

showCapital( "andora" )
showCapital( "US" )

val
fruit = List("apple", "pear", "orange", "pineapple")
fruit sortWith (_.length < _.length)
fruit.sorted
fruit groupBy( _.head )