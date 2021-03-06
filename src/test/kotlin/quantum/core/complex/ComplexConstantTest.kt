package quantum.core.complex

import org.junit.Test
import quantum.core.Complex.Companion.I
import quantum.core.Complex.Companion.One
import quantum.core.Complex.Companion.Zero
import kotlin.test.assertEquals

class ComplexConstantTest {


    @Test
    fun testConstZero() {
        assertEquals(0.0, Zero.real)
        assertEquals(0.0, Zero.imaginary)
    }

    @Test
    fun testConstOne() {
        assertEquals(1.0, One.real)
        assertEquals(0.0, One.imaginary)
    }

    @Test
    fun testConstI() {
        assertEquals(0.0, I.real)
        assertEquals(1.0, I.imaginary)
    }
}