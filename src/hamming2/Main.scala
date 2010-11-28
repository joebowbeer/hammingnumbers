package hamming2

import scala.collection.mutable.PriorityQueue

/**
 * Alternate implementation using a <tt>PriorityQueue</tt>.
 */
object Main {

  def hamming: Stream[Int] = {
    val q = new PriorityQueue[Int]()(Ordering[Int].reverse) += 1
    def nextHamming: Stream[Int] = {
      val n = q.dequeue
      while (q.headOption.exists(n==))
        q.dequeue
      q += (2*n, 3*n, 5*n)
      Stream.cons(n, nextHamming)
    }
    nextHamming
  }

  def main(args: Array[String]): Unit = {
    println(hamming.slice(0, args(0).toInt).toList)
  }
}
