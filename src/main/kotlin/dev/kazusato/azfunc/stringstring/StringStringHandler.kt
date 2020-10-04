package dev.kazusato.azfunc.stringstring

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler
import java.util.*

class StringStringHandler : AzureSpringBootRequestHandler<String, String>() {

	@FunctionName("welcome")
	fun exec(
			@HttpTrigger(name = "req", methods = [HttpMethod.POST], authLevel = AuthorizationLevel.ANONYMOUS)
			req: HttpRequestMessage<Optional<String>>,
			ctx: ExecutionContext
	): HttpResponseMessage {
		return req.createResponseBuilder(HttpStatus.OK)
				.body(handleRequest(req.body.get(), ctx))
				.header("Content-Type", "plain/text")
				.build()
	}

}