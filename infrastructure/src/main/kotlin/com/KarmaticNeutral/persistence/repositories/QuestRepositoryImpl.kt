package com.KarmaticNeutral.persistence.repositories

import com.KarmaticNeutral.interfaces.repositories.QuestRepository
import com.KarmaticNeutral.persistence.entities.ItemEntity
import com.KarmaticNeutral.persistence.entities.QuestEntity
import com.KarmaticNeutral.persistence.repositories.springRepositories.SpringQuestRepository
import com.KarmaticNeutral.valueObjects.Quest
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.concurrent.CompletableFuture

@Service
class QuestRepositoryImpl(private val springQuestRepository: SpringQuestRepository) : QuestRepository {
	override fun getActiveForUserAsync(userId: Long): CompletableFuture<List<Quest>> {
		return springQuestRepository.findActiveByUserIdAsync(userId).handleAsync { entities, ex ->
			if (ex != null) {
				throw ex
			} else {
				entities.map { it.toQuest() }
			}
		}
	}

	override fun findAsync(id: Long): CompletableFuture<Quest> {
		val t = ItemEntity(1, "item", "An item!",1f, 1f, "rarity", 1, Timestamp(1), 1 , Timestamp(1), false, null, null)
		t.Rarity = "Common"
		TODO("Not yet implemented")
	}

	override fun saveAsync(quest: Quest, userId: Long): CompletableFuture<Long> {
		val questEntity = QuestEntity(
			quest.getId(),
			quest.getName(),
			quest.getDescription(),
			quest.getType(),
			quest.getRarity(),
			quest.getExpReward().toInt(),
			quest.getGoldReward().toInt(),
			listOf(), //TODO implement
			userId, //TODO current user service
			Timestamp(1),
			userId,
			Timestamp(1),
			false,
			null,
			null
		)
		return springQuestRepository.saveAsync(questEntity).handleAsync { entity, ex ->
			if (ex != null) {
				throw ex
			} else {
				entity.Id
			}
		}
	}

	override fun deleteAsync(entity: Quest): CompletableFuture<Void> {
		return springQuestRepository.deleteAsync(entity.getId())
	}
}