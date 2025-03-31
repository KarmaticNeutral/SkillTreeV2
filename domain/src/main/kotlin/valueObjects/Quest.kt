package valueObjects

import customDataTypes.NonNegativeInt
import enums.QuestType
import enums.Rarity

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