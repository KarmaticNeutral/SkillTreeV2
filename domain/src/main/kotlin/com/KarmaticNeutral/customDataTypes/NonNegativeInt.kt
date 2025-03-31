package com.KarmaticNeutral.customDataTypes

class NonNegativeInt private constructor(private val value: Int) {
	init {
		require(value >= 0) { "Value must be non-negative" }
	}

	companion object {
		@JvmStatic
		fun of(value: Int): NonNegativeInt {
			return NonNegativeInt(value)
		}

		@JvmStatic
		fun of(value: String): NonNegativeInt {
			return of(value.toInt())
		}
	}

	override fun toString(): String {
		return value.toString()
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is NonNegativeInt) return false
		return value == other.value
	}

	override fun hashCode(): Int {
		return value
	}

	operator fun plus(other: NonNegativeInt): NonNegativeInt {
		return NonNegativeInt(value + other.value)
	}

	operator fun minus(other: NonNegativeInt): NonNegativeInt {
		return NonNegativeInt(value - other.value)
	}

	operator fun times(other: NonNegativeInt): NonNegativeInt {
		return NonNegativeInt(value * other.value)
	}

	operator fun div(other: NonNegativeInt): NonNegativeInt {
		return NonNegativeInt(value / other.value)
	}

	operator fun rem(other: NonNegativeInt): NonNegativeInt {
		return NonNegativeInt(value % other.value)
	}

	operator fun compareTo(other: NonNegativeInt): Int {
		return value.compareTo(other.value)
	}

	fun toInt(): Int {
		return value
	}
}