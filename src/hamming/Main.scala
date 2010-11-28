package hamming

/**
 * Prints the first several Hamming numbers. Adapted from SICP
 * (<a href="http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-24.html#%_thm_3.56">
 * Exercise 3.56</a>).
 */
object Main {

  def hamming: Stream[Int] =
    Stream.cons(1, merge(hamming.map(2*), merge(hamming.map(3*), hamming.map(5*))))

  def merge[T](a: Stream[T], b: Stream[T])(implicit ord: Ordering[T]): Stream[T] = {
    if (b.isEmpty)
      a
    else if (a.isEmpty)
      b
    else {
      val order = ord.compare(a.head, b.head)
      if (order < 0)
        Stream.cons(a.head, merge(a.tail, b))
      else if (order > 0)
        Stream.cons(b.head, merge(a, b.tail))
      else
        Stream.cons(a.head, merge(a.tail, b.tail))
    }
  }

  def main(args: Array[String]): Unit = {
    println(hamming.slice(0, args(0).toInt).toList)
  }
}
