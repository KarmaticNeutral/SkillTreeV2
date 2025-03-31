package com.KarmaticNeutral.enums;

enum class QuestType {
	FETCH,
	FIGHTING,
	BOSS,
	DISCOVERY;

	companion object {
		fun fromString(type: String): QuestType {
			return when (type) {
				"FETCH" -> FETCH
				"FIGHTING" -> FIGHTING
				"BOSS" -> BOSS
				"DISCOVERY" -> DISCOVERY
				else -> throw IllegalArgumentException("Found invalid string when parsing quest type: $type") //TODO test this
			}
		}
	}
}
