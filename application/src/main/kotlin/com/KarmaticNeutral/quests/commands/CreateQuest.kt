package com.KarmaticNeutral.quests.commands

import com.KarmaticNeutral.common.AbstractHandler
import com.KarmaticNeutral.common.AbstractRequest
import com.KarmaticNeutral.interfaces.repositories.QuestRepository
import org.springframework.stereotype.Service
import com.KarmaticNeutral.valueObjects.Quest
import java.util.concurrent.CompletableFuture

class CreateQuestRequest(val userId: Long, val quest: Quest): AbstractRequest<CompletableFuture<Long>>()

@Service
class CreateQuestHandler(private val questRepository: QuestRepository) : AbstractHandler<CreateQuestRequest, CompletableFuture<Long>>() {
	override fun handle(request: CreateQuestRequest): CompletableFuture<Long> {
		return questRepository.save(request.quest, request.userId)
	}
}
