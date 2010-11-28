package hamming

import org.junit._
import org.junit.Assert._

class HammingTest {

  @Before
  def setUp: Unit = {
  }

  @After
  def tearDown: Unit = {
  }

  @Test
  def hamming6 = {
    assertEquals((1 to 6), hammingList(6))
  }

  @Test
  def hamming12 = {
    assertEquals(List(1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16), hammingList(12))
  }

  def hammingList(i: Int): List[Int] = {
    Hamming.hamming.slice(0, i).toList
  }
}
