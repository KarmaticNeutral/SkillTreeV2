package com.KarmaticNeutral.verbs

import com.KarmaticNeutral.common.SuccessStatus
import java.util.concurrent.CompletableFuture

abstract class AbstractVerb {
	abstract val name: String
	abstract fun execute(args: List<String>): CompletableFuture<SuccessStatus>
}