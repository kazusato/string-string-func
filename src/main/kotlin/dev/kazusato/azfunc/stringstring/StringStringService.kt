package dev.kazusato.azfunc.stringstring

import org.springframework.stereotype.Service
import java.util.function.Function

@Service
class StringStringService : Function<String, String> {

	override fun apply(req: String): String {
		return "Welcome, ${req}!"
	}

}