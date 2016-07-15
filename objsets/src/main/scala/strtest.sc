import objsets.TweetReader
import objsets.TweetSet

val wordList = List("akka", "scala", "play framework", "sbt", "typesafe")
val tweet = "This is an example tweet talking about  and "

//(wordList.foldLeft(false)( _ || tweet.contains(_) ))
wordList.exists(tweet.contains)

//val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
//val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

//TweetReader.allTweets
//val googleTweets: TweetSet = TweetReader.allTweets.filter( tw => { val twStr = tw.user + tw.text
//  (google.foldLeft(false)( _ || twStr.contains(_) ))
//  google.exists(twStr.contains)})