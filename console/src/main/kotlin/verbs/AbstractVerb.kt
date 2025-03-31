package verbs

import common.SuccessStatus
import java.util.concurrent.CompletableFuture

abstract class AbstractVerb {
	abstract val name: String
	abstract fun execute(): CompletableFuture<SuccessStatus>
}