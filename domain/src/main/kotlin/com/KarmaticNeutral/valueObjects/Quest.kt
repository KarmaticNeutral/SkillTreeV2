package com.KarmaticNeutral.valueObjects

import com.KarmaticNeutral.customDataTypes.NonNegativeInt
import com.KarmaticNeutral.enums.QuestType
import com.KarmaticNeutral.enums.Rarity

class Quest(private val id: Long,
			private val name: String,
			private val description: String,
			private val type: QuestType,
			private val rarity: Rarity,

			private val expReward: NonNegativeInt,
			private val goldReward: NonNegativeInt,
			private val itemRewards: List<Item>) {
	init {
		if (name == "") throw IllegalArgumentException("Name cannot be empty")
		if (description == "") throw IllegalArgumentException("Description cannot be empty")
	}

	constructor(id: String, name: String, description: String, type: String, rarity: String, expReward: String, goldReward: String)
		: this(
			id.toLong(),
			name,
			description,
			QuestType.fromString(type),
			Rarity.fromString(rarity),
			NonNegativeInt.of(expReward),
			NonNegativeInt.of(goldReward),
			listOf()
		)

	fun getId(): Long {
		return id
	}

	fun getName(): String {
		return name
	}

	fun getDescription(): String {
		return description
	}

	fun getType(): QuestType {
		return type
	}

	fun getRarity(): Rarity {
		return rarity
	}

	fun getExpReward(): NonNegativeInt {
		return expReward
	}

	fun getGoldReward(): NonNegativeInt {
		return goldReward
	}

	fun getItemRewards(): List<Item> {
		return itemRewards
	}
}