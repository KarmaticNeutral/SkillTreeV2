package verbs

import common.SuccessStatus
import java.util.concurrent.CompletableFuture

class GetActiveQuestsForUserVerb(): AbstractVerb() {
	override val name: String = "get-active-quests-for-user"

	override fun execute(): CompletableFuture<SuccessStatus> {
		try {
			TODO("Not yet implemented")
		} catch (e: Exception) {
			return CompletableFuture.failedFuture(e)
		}
	}
}