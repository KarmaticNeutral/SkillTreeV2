package com.KarmaticNeutral.interfaces.repositories

import com.KarmaticNeutral.valueObjects.Quest
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
interface QuestRepository {
	fun getActiveForUser(userId: Long): CompletableFuture<List<Quest>>
	fun get(id: Long): CompletableFuture<Quest>
	fun save(quest: Quest, userId: Long): CompletableFuture<Long>
}