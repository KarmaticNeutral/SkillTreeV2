package quests.commands

import common.AbstractHandler
import common.AbstractRequest
import interfaces.repositories.QuestRepository
import valueObjects.Quest
import java.util.concurrent.CompletableFuture

class CreateQuestRequest(userId: Long, quest: Quest): AbstractRequest<CompletableFuture<Long>>()

class CreateQuestHandler(private val questRepository: QuestRepository) : AbstractHandler<CreateQuestRequest, CompletableFuture<Long>>() {
	override fun handle(request: CreateQuestRequest): CompletableFuture<Long> {
		TODO("Not yet implemented")
	}
}
