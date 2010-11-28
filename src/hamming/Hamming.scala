package hamming

import Streams.merge

/**
 * Prints the first several Hamming numbers. Adapted from SICP
 * (<a href="http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-24.html#%_thm_3.56">
 * Exercise 3.56</a>).
 */
object Hamming {

  def hamming: Stream[Int] =
    Stream.cons(1, merge(hamming.map(2*), merge(hamming.map(3*), hamming.map(5*))))

  def main(args: Array[String]): Unit = {
    println(hamming.slice(0, args(0).toInt).toList)
  }
}
