package com.KarmaticNeutral.persistence.entities

import com.KarmaticNeutral.enums.QuestType
import com.KarmaticNeutral.enums.Rarity
import java.sql.Timestamp

class QuestEntity(
	id: Long, title: String, description: String, type: QuestType, rarity: Rarity, goldReward: Int, expReward: Int, itemRewards: List<ItemEntity>,
	createdBy: Long, createdAt: Timestamp, updatedBy: Long, updatedAt: Timestamp, isDeleted: Boolean, deletedBy: Long?, deletedAt: Timestamp?
)
	: AuditableTimestampEntity(createdBy, createdAt, updatedBy, updatedAt, isDeleted, deletedBy, deletedAt) {
	private var _id: Long = id
	var Id: Long
		get() = _id
		set(value) { _id = value }

	private var _title: String = title
	var Title: String
		get() = _title
		set(value) { _title = value }

	private var _description: String = description
	var Description: String
		get() = _description
		set(value) { _description = value }

	private var _type: QuestType = type
	var Type: QuestType
		get() = _type
		set(value) { _type = value }

	private var _rarity: Rarity = rarity
	var Rarity: Rarity
		get() = _rarity
		set(value) { _rarity = value }

	private var _goldReward: Int = goldReward
	var GoldReward: Int
		get() = _goldReward
		set(value) { _goldReward = value }

	private var _expReward: Int = expReward
	var ExpReward: Int
		get() = _expReward
		set(value) { _expReward = value }

	private var _itemRewards: List<ItemEntity> = itemRewards
	var ItemRewards: List<ItemEntity>
		get() = _itemRewards
		set(value) { _itemRewards = value }
}
