package com.KarmaticNeutral.persistence.entities

import com.KarmaticNeutral.valueObjects.Item
import com.KarmaticNeutral.valueObjects.Quest
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.sql.Timestamp

class QuestRewardsEntity(
	id: Long, itemId: Long, questId: Long, itemEntity: ItemEntity, questEntity: QuestEntity,
	createdBy: Long, createdAt: Timestamp, updatedBy: Long, updatedAt: Timestamp, isDeleted: Boolean, deletedBy: Long, deletedAt: Timestamp
) : AuditableTimestampEntity(createdBy, createdAt, updatedBy, updatedAt, isDeleted, deletedBy, deletedAt) {
	private var _id: Long = id
	var Id: Long
		get() = _id
		set(value) { _id = value }

	private var _itemId: Long = itemId
	var ItemId: Long
		get() = _itemId
		set(value) { _itemId = value }

	private var _questId: Long = questId
	var QuestId: Long
		get() = _questId
		set(value) { _questId = value }

	@OneToOne
	private var _itemEntity: ItemEntity = itemEntity
	var ItemEntity: ItemEntity
		get() = _itemEntity
		set(value) { _itemEntity = value }

	@ManyToOne
	private var _questEntity: QuestEntity = questEntity
	var QuestEntity: QuestEntity
		get() = _questEntity
		set(value) { _questEntity = value }

	fun toItem(): Item {
		return ItemEntity.toItem()
	}

	fun toQuest(): Quest {
		return QuestEntity.toQuest()
	}
}
