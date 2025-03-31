package common

abstract class AbstractHandler<TRequest: AbstractRequest<TResponse>, TResponse> {
	abstract fun handle(request: TRequest): TResponse
}