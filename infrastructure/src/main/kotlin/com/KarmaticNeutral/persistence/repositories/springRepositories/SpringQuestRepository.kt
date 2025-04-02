package com.KarmaticNeutral.persistence.repositories.springRepositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.KarmaticNeutral.persistence.entities.QuestEntity
import org.springframework.scheduling.annotation.Async
import java.util.*
import java.util.concurrent.CompletableFuture

@Repository
interface SpringQuestRepository: CrudRepository<QuestEntity, Long> {
	//Create
	@Async fun saveAsync(entity: QuestEntity): CompletableFuture<QuestEntity>

	//Read
	@Async fun findByIdAsync(id: Long): CompletableFuture<Optional<QuestEntity>>
	@Async fun findActiveByUserIdAsync(userId: Long): CompletableFuture<List<QuestEntity>>

	//Update

	//Delete
	@Async fun deleteAsync(id: Long): CompletableFuture<Void>
}
