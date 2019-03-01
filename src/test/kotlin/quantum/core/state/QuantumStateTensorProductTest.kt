package quantum.core.state

import org.junit.Test
import quantum.core.Complex
import quantum.core.Complex.Companion.complex
import quantum.core.Qubit
import quantum.util.assertComplexEquals
import quantum.util.assertComplexIndexedValueIteratorEquals
import kotlin.test.assertEquals

class QuantumStateTensorProductTest {

    val OneHalf = complex(0.5)

    /**
     * (1, 0) * (1, 0) = (1, 0, 0, 0)
     */
    @Test
    fun testTensorProductZeroZero() {

        val quantumState = Qubit.Zero tensor Qubit.Zero

        assertEquals(4, quantumState.size)
        assertComplexIndexedValueIteratorEquals(
                quantumState.indexedValueIterator(),
                intArrayOf(0),
                arrayOf(Complex.One)
        )

    }

    /**
     * (1, 0) * (0, 1) = (0, 1, 0, 0)
     */
    @Test
    fun testTensorProductZeroOne() {

        val quantumState = Qubit.Zero tensor Qubit.One

        assertEquals(4, quantumState.size)
        assertComplexIndexedValueIteratorEquals(
                quantumState.indexedValueIterator(),
                intArrayOf(1),
                arrayOf(Complex.One)
        )
    }

    /**
     * (0, 1) * (0, 1) = (0, 0, 0, 1)
     */
    @Test
    fun testTensorProductOneOne() {

        val quantumState = Qubit.One tensor Qubit.One

        assertEquals(4, quantumState.size)
        assertComplexIndexedValueIteratorEquals(
                quantumState.indexedValueIterator(),
                intArrayOf(3),
                arrayOf(Complex.One)
        )

    }

    /**
     * 1/sqrt(2) (1, 1) * 1/sqrt(2) (1, -1) =
     * 1/2 (1, -1, 1, -1)
     */
    @Test
    fun testTensorPlusMinus() {
        val quantumState = Qubit.Plus tensor Qubit.Minus

        assertEquals(4, quantumState.size)
        assertComplexIndexedValueIteratorEquals(
                quantumState.indexedValueIterator(),
                intArrayOf(0, 1, 2, 3),
                arrayOf(OneHalf, -OneHalf, OneHalf, -OneHalf)
        )
    }
}