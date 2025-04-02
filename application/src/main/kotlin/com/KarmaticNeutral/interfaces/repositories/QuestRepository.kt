package com.KarmaticNeutral.interfaces.repositories

import com.KarmaticNeutral.valueObjects.Quest
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
interface QuestRepository {
	//Create
	fun saveAsync(quest: Quest, userId: Long): CompletableFuture<Long>

	//Read
	fun getActiveForUserAsync(userId: Long): CompletableFuture<List<Quest>>
	fun findAsync(id: Long): CompletableFuture<Quest>

	//Update

	//Delete
	fun deleteAsync(entity: Quest): CompletableFuture<Void>
}