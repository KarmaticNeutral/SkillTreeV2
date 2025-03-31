package com.KarmaticNeutral.valueObjects

import com.KarmaticNeutral.constants.LevelConstants

class UserData(
	private val id: Long,
	private val username: String,
	private val level: Int,
	private val exp: Int
) {
	val atMaxLevel: Boolean = level == LevelConstants.MAX_LEVEL
	val expForThisLevel: Int = if (atMaxLevel) 0 else requireNotNull(LevelConstants.EXP_TO_LEVEL_MAP[level])
}
