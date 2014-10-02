# Abstractions

This repository holds the presentation and the code for a talk given at the [Goto Night Berlin ](https://secure.trifork.com/berlin-2014/freeevent/index.jsp?eventOID=6508). The presentation is in the folder named presentation, `abstractions.html` and a set of quotes on Abstractions can be seen in `quotes.html` also in the same folder.

This is also an sbt project with the source under `src/main/scala`. An `sbt console` session (REPL session) might look like this 


```scala 
% sbt 
> console 
[info] Starting scala interpreter...
[info] 
import goto._
import SemigroupOps._
import EqualOps._
import Sums._
Welcome to Scala version 2.10.4 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_55).
Type in expressions to have them evaluated.
Type :help for more information.

scala> SemigroupProps.laws[Int].check 
+ semigroup.associativity: OK, passed 100 tests.

scala> SemigroupProps.laws[Int].check(_.withMinSuccessfulTests(1000000))
+ semigroup.associativity: OK, passed 1000000 tests.

scala> sum(List(1,2,3), List(3,4,5))
res0: List[Int] = List(1, 2, 3, 3, 4, 5)

scala> SemigroupProps.laws[List[Int]].check
+ semigroup.associativity: OK, passed 100 tests.

scala> sum(Tree(1,2,3,4))
res1: Int = 10

scala> val jan = Map("€" -> 100, "$" -> 900, "#" -> 300)
jan: scala.collection.immutable.Map[String,Int] = Map(€ -> 100, $ -> 900, # -> 300)

scala> val feb = Map("€" -> 900, "#" -> 500)
feb: scala.collection.immutable.Map[String,Int] = Map(€ -> 900, # -> 500)

scala> sum(List(jan, feb))
res3: scala.collection.immutable.Map[String,Int] = Map(€ -> 1000, # -> 800, $ -> 900)

scala> MonoidProps.laws[Int].check
+ monoid.associativity: OK, passed 100 tests.
+ monoid.left identity: OK, passed 100 tests.
+ monoid.right identity: OK, passed 100 tests.

scala> sumMap(List('a','b', 'c'))(_.toInt)
res4: Int = 294

scala> implicit val mult = Monoid.lift(1)(Semigroup.lift(_ * _))
mult: goto.Monoid[Int] = goto.Monoid$$anon$2@771786bd

scala> sum(Tree(1,2,3,4,5))
res?: Int = 120

scala> implicit val faultyInt : Semigroup[Int] = Semigroup.lift(_ - _)
faultyInt: goto.Semigroup[Int] = goto.Semigroup$$anon$2@72ed3f7c

scala> SemigroupProps.laws[Int].check
! semigroup.associativity: Falsified after 0 passed tests.
> ARG_0: 2147483647
> ARG_1: -2147483648
> ARG_2: -1

scala> SemigroupProps.laws[Int].check
! semigroup.associativity: Falsified after 1 passed tests.
> ARG_0: 1638367680
> ARG_1: 1
> ARG_2: -1527235181
```



The source is organized into type-classes representing the various abstractions. `Sums` includes the `sum` used as a vehicle to introduce the various abstractions.    




