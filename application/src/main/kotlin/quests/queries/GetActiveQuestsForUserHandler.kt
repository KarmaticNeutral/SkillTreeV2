import common.AbstractRequest
import interfaces.repositories.QuestRepository
import valueObjects.Quest
import java.util.concurrent.CompletableFuture

class GetActiveQuestsForUserRequest(userId: Long) : AbstractRequest<CompletableFuture<List<Quest>>>()

class GetActiveQuestsForUserHandler(private val questRepository: QuestRepository) {
	fun execute(userId: Long): CompletableFuture<List<Quest>> {
		return questRepository.getActiveForUser(userId)
	}
}