package quantum.blocks


data class Complex(val real: Double, val imaginary: Double) {

    constructor(real: Int) : this(real.toDouble())
    constructor(real: Int, imaginary: Int) : this(real.toDouble(), imaginary.toDouble())

    constructor(real: Double) : this(real, 0.0)

    companion object {
        val ZERO = Complex(0)
        val ONE = Complex(1)
        val I = Complex(0, 1)
    }

    operator fun div(other: Int): Complex = div(other.toDouble())
    operator fun div(other: Double): Complex = Complex(real / other, imaginary / other)

    operator fun plus(other: Complex): Complex = Complex(real + other.real, imaginary + other.imaginary)
    operator fun times(other: Complex): Complex = Complex(
            real * other.real - imaginary * other.imaginary,
            real * other.imaginary + imaginary * other.real)


    fun sqr(): Double = real * real + imaginary * imaginary
    fun norm(): Double = kotlin.math.sqrt(sqr())
}