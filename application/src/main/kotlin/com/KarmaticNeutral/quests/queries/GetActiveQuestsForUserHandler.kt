package com.KarmaticNeutral.quests.commands

import com.KarmaticNeutral.common.AbstractHandler
import com.KarmaticNeutral.common.AbstractRequest
import com.KarmaticNeutral.interfaces.repositories.QuestRepository
import com.KarmaticNeutral.valueObjects.Quest
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

class GetActiveQuestsForUserRequest(val userId: Long) : AbstractRequest<CompletableFuture<List<Quest>>>()

@Service
class GetActiveQuestsForUserHandler(private val questRepository: QuestRepository): AbstractHandler<GetActiveQuestsForUserRequest, CompletableFuture<List<Quest>>>() {
	override fun handle(request: GetActiveQuestsForUserRequest): CompletableFuture<List<Quest>> {
		return questRepository.getActiveForUser(request.userId)
	}
}