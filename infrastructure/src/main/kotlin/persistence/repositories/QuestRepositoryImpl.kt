package persistence.repositories

import interfaces.repositories.QuestRepository
import persistence.entities.ItemEntity
import persistence.repositories.springRepositories.SpringQuestRepository
import valueObjects.Quest
import java.sql.Timestamp
import java.util.concurrent.CompletableFuture

class QuestRepositoryImpl(private val springQuestRepository: SpringQuestRepository) : QuestRepository {
	override fun getActiveForUser(userId: Long): CompletableFuture<List<Quest>> {
		TODO("Not yet implemented")
	}

	override fun get(id: Long): CompletableFuture<Quest> {
		val t = ItemEntity(1, "item", 1f, 1f, "rarity", 1, Timestamp(1), 1 , Timestamp(1), false, null, null)
		t.Rarity = "Common"
		TODO("Not yet implemented")
	}

	override fun save(quest: Quest): CompletableFuture<Long> {
		TODO("Not yet implemented")
	}
}