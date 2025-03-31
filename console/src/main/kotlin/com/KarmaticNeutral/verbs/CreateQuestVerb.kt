package com.KarmaticNeutral.verbs

import com.KarmaticNeutral.common.SuccessStatus
import com.KarmaticNeutral.quests.commands.CreateQuestHandler
import com.KarmaticNeutral.quests.commands.CreateQuestRequest
import com.KarmaticNeutral.valueObjects.Quest
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class CreateQuestVerb(private val createQuestHandler: CreateQuestHandler): AbstractVerb() {
	override val name: String = "create-quest"

	override fun execute(args: List<String>): CompletableFuture<SuccessStatus> {
		val quest: Quest
		try {
			quest = Quest(args[1], args[2], args[3], args[4], args[5], args[6], args[7])
		} catch (e: Exception) { //TODO figure out we want to handle errors
			return CompletableFuture.failedFuture(e)
		}

		val userId: Long
		try {
			userId = args[0].toLong()
		} catch (e: Exception) { //TODO figure out we want to handle errors
			return CompletableFuture.failedFuture(e)
		}

		try {
			createQuestHandler.handle(CreateQuestRequest(userId, quest))
		} catch (e: Exception) { //TODO figure out we want to handle errors
			return CompletableFuture.failedFuture(e)
		}

		return CompletableFuture.completedFuture(SuccessStatus.SUCCESS)
	}
}