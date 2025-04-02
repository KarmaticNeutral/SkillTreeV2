package com.KarmaticNeutral.persistence.entities

import com.KarmaticNeutral.customDataTypes.NonNegativeInt
import com.KarmaticNeutral.enums.QuestType
import com.KarmaticNeutral.enums.Rarity
import com.KarmaticNeutral.persistence.entities.QuestEntity.Companion.FIND_ACTIVE_BY_USER_ID_ASYNC
import com.KarmaticNeutral.persistence.entities.QuestEntity.Companion.FIND_BY_ID_ASYNC
import com.KarmaticNeutral.persistence.entities.QuestEntity.Companion.SAVE_ASYNC
import com.KarmaticNeutral.persistence.entities.QuestEntity.Companion.TABLE_NAME
import com.KarmaticNeutral.valueObjects.Quest
import jakarta.persistence.*
import java.sql.Timestamp

@Table(name = TABLE_NAME)
@NamedQueries(
	NamedQuery(name = FIND_ACTIVE_BY_USER_ID_ASYNC,
		query = """
			SELECT q FROM QuestEntity q 
			WHERE q.IsDeleted = false 
			AND q.CreatedBy = :userId
		"""
	),
	NamedQuery(name = FIND_BY_ID_ASYNC,
		query = """
			SELECT q FROM QuestEntity q
			WHERE q.IsDeleted = false
			AND q.Id = :id
		"""
	),
	NamedQuery(name = SAVE_ASYNC,
		query = """
			INSERT INTO QuestEntity q
		"""
	)
)
class QuestEntity(
	id: Long, title: String, description: String, type: QuestType, rarity: Rarity, goldReward: Int, expReward: Int, questRewards: List<QuestRewardsEntity>,
	createdBy: Long, createdAt: Timestamp, updatedBy: Long, updatedAt: Timestamp, isDeleted: Boolean, deletedBy: Long?, deletedAt: Timestamp?
) : AuditableTimestampEntity(createdBy, createdAt, updatedBy, updatedAt, isDeleted, deletedBy, deletedAt) {
	companion object {
		const val TABLE_NAME = "quests"
		const val FIND_ACTIVE_BY_USER_ID_ASYNC = "QuestEntity.findActiveByUserIdAsync"
		const val FIND_BY_ID_ASYNC = "QuestEntity.findByIdAsync"
		const val SAVE_ASYNC = "QuestEntity.saveAsync"
	}

	@Id
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

	@OneToMany(cascade = [CascadeType.ALL])
	@JoinColumn(name = "quest_id")
	private var _questRewards: List<QuestRewardsEntity> = questRewards
	var QuestRewards: List<QuestRewardsEntity>
		get() = _questRewards
		set(value) { _questRewards = value }

	fun toQuest(): Quest {
		return Quest(Id, Title, Description, Type, Rarity, NonNegativeInt.Companion.of(ExpReward), NonNegativeInt.Companion.of(GoldReward), QuestRewards.map { it.toItem() })
	}
}
