package constants

class LevelConstants {
	companion object {
		const val MAX_LEVEL = 100
		val EXP_TO_LEVEL_MAP = (0..MAX_LEVEL).associateWith { level -> level * 1000 } //TODO improve exp required to level
	}
}