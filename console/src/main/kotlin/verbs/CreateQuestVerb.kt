package verbs

import common.SuccessStatus
import java.util.concurrent.CompletableFuture

class CreateQuestVerb(): AbstractVerb() {
	override val name: String = "create-quest"

	override fun execute(): CompletableFuture<SuccessStatus> {
		try {
			TODO("Not yet implemented")
		} catch (e: Exception) {
			return CompletableFuture.failedFuture(e)
		}
	}
}