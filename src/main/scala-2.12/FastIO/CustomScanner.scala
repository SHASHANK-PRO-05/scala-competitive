package FastIO

import java.io.{BufferedReader, InputStreamReader, LineNumberReader, Reader}
import java.util.StringTokenizer

/**
  * Created by home on 12/21/2016.
  */
class CustomScanner(reader: LineNumberReader) extends Iterator[String] with AutoCloseable {
  /**
    *
    * First setting up the readers that can be passed here
    */
  def this(reader: BufferedReader) = this(new LineNumberReader(reader));

  def this(reader: Reader) = this(new BufferedReader(reader));

  def this() = this(new BufferedReader(new InputStreamReader(System.in)))


  /**
    * Setting up the tokenizer elements
    **/
  private[this] val tokenizers = Iterator.continually(reader.readLine()).takeWhile(_ != null).map(new StringTokenizer(_)).filter(_.hasMoreTokens());
  private[this] var current: Option[StringTokenizer] = None;

  private[this] def tokenizer(): Option[StringTokenizer] = current.find(_.hasMoreElements) orElse {
    current = if (tokenizers.hasNext) Some(tokenizers.next()) else None
    current
  }

  /**
    * Setting up the base functionality
    */
  def nextLine(): String = {
    current = None
    reader.readLine()
  }

  def lineNumber(): Int = reader.getLineNumber()

  def line(): String = tokenizer().get.nextToken("\n\r");

  def nextString(): String = next()

  def nextChar(): Char = next().ensuring(_.length == 1).head

  def nextBoolean(): Boolean = next().toBoolean

  def nextByte(radix: Int = 10): Byte = java.lang.Byte.parseByte(next(), radix)

  def nextShort(radix: Int = 10): Short = java.lang.Short.parseShort(next(), radix)

  def nextInt(radix: Int = 10): Int = java.lang.Integer.parseInt(next(), radix)

  def nextLong(radix: Int = 10): Long = java.lang.Long.parseLong(next(), radix)

  def nextBigInt(radix: Int = 10): BigInt = BigInt(next(), radix)

  def nextFloat(): Float = next().toFloat

  def nextDouble(): Double = next().toDouble

  def nextBigDecimal(): BigDecimal = BigDecimal(next())

  override def hasNext: Boolean = tokenizer().nonEmpty

  override def next(): String = tokenizer().get.nextToken()

  override def close() = reader.close()
}
