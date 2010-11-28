package hamming

object Streams {

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
}
