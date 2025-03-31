package com.KarmaticNeutral.enums

import HexCodeColor

enum class Rarity(val color: HexCodeColor) {
	COMMON(HexCodeColor("#000000")),
	UNCOMMON(HexCodeColor("#00FF00")),
	RARE(HexCodeColor("#0000FF")),
	VERY_RARE(HexCodeColor("#FF0000")),
	LEGENDARY(HexCodeColor("#FF00FF")),
	MYTHIC(HexCodeColor("#FFFF00"));

	companion object{
		fun fromString(name: String): Rarity {
			return valueOf(name)
		} //TODO test this
	}
}