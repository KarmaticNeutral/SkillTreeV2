class HexCodeColor(private val red: HexCodeColorPart, private val green: HexCodeColorPart, private val blue: HexCodeColorPart) {
	constructor(hexString: String) : this(hexString.substring(1, 3).toInt(16), hexString.substring(3, 5).toInt(16), hexString.substring(5, 7).toInt(16))
	constructor(red: Int, green: Int, blue: Int) : this(HexCodeColorPart(red), HexCodeColorPart(green), HexCodeColorPart(blue))

	override fun toString(): String {
		return "#$red$green$blue"
	}
}