package quantum.operator

import org.junit.Test
import quantum.core.toComplex
import quantum.gate.identity
import kotlin.test.assertEquals

class IdentityOperatorTest {

    @Test
    fun testElements() {
        val identity = identity()

        assertEquals(2, identity.rows)
        assertEquals(2, identity.columns)
        assertEquals(1.0.toComplex(), identity.get(0, 0))
        assertEquals(0.0.toComplex(), identity.get(0, 1))
        assertEquals(0.0.toComplex(), identity.get(1, 0))
        assertEquals(1.0.toComplex(), identity.get(1, 1))
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun testRowOutOfBounds() {
        identity().get(2, 0)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun testColumnOutOfBounds() {
        identity().get(0, 2)
    }
}