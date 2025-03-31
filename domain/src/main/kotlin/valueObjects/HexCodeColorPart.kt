class HexCodeColorPart(private val color: Int) {
	init {
		if (color !in 0..255) {
			throw IllegalArgumentException("Invalid color: #${color.toString(16)}")
		}
	}

	override fun toString(): String {
		return color.toString(16).padStart(2, '0')
	}
}