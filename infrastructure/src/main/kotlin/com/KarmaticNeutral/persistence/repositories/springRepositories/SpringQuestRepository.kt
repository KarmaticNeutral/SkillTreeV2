package com.KarmaticNeutral.persistence.repositories.springRepositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.KarmaticNeutral.persistence.entities.QuestEntity
import org.springframework.scheduling.annotation.Async
import java.util.*
import java.util.concurrent.CompletableFuture

@Repository
interface SpringQuestRepository: CrudRepository<QuestEntity, Long> {
	@Async
	fun save(entity: QuestEntity): CompletableFuture<QuestEntity>

	@Asnyc
	override fun findById(id: Long): CompletableFuture<Optional<QuestEntity>>

	@Async
	fun findActiveByUserId(userId: Long): CompletableFuture<List<QuestEntity>>
}
