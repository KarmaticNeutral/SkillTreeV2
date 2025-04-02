package com.KarmaticNeutral.valueObjects

import com.KarmaticNeutral.constants.LevelConstants

class UserData(id: Long, username: String, level: Int, exp: Int) {
	private var _id = id
	var Id get() = _id
		set(value) { _id = value }

	private var _username = username
	var Username get() = _username
		set(value) { _username = value }

	private var _level = level
	var Level get() = _level
		set(value) { _level = value }

	private var _exp = exp
	var Exp get() = _exp
		set(value) { _exp = value }

	private fun atMaxLevel(): Boolean {
		return Level == LevelConstants.MAX_LEVEL
	}

	private fun expForThisLevel(): Int {
		return if (atMaxLevel()) 0 else requireNotNull(LevelConstants.EXP_TO_LEVEL_MAP[Level])
	}

	public fun expToNextLevel(): Int {
		return expForThisLevel() - Exp
	}

	private fun gainLevel() {
		Level += 1
	}

	fun gainExp(amount: Int) {
		val newExp = Exp + amount
		val neededExp = requireNotNull(LevelConstants.EXP_TO_LEVEL_MAP[Level])
		if (neededExp <= newExp) {
			gainLevel()
			Exp = newExp - neededExp
		} else {
			Exp = newExp
		}
	}
}
