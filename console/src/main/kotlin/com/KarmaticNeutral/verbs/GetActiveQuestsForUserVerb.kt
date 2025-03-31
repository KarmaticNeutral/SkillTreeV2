package com.KarmaticNeutral.verbs

import com.KarmaticNeutral.common.SuccessStatus
import com.KarmaticNeutral.quests.commands.GetActiveQuestsForUserHandler
import com.KarmaticNeutral.quests.commands.GetActiveQuestsForUserRequest
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class GetActiveQuestsForUserVerb(private val getActiveQuestsForUserHandler: GetActiveQuestsForUserHandler): AbstractVerb() {
	override val name: String = "get-active-quests-for-user"

	override fun execute(args: List<String>): CompletableFuture<SuccessStatus> {
		try {
			return getActiveQuestsForUserHandler.handle(GetActiveQuestsForUserRequest(args[0].toLong()))
				.thenApply { quests ->
					quests.forEach { quest -> println(quest.toString()) }
					SuccessStatus.SUCCESS
				}
		} catch (e: Exception) {
			return CompletableFuture.failedFuture(e)
		}
	}
}