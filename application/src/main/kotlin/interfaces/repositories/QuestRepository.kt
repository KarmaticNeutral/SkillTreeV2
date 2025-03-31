package interfaces.repositories

import valueObjects.Quest
import java.util.concurrent.CompletableFuture

interface QuestRepository {
	fun getActiveForUser(userId: Long): CompletableFuture<List<Quest>>
	fun get(id: Long): CompletableFuture<Quest>
	fun save(quest: Quest): CompletableFuture<Long>
}