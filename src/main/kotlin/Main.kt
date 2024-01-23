import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

// Note: These two imports must be present to find the correct overloads for polymorphic and
// subclass used below.
/*
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
 */

interface Super { }

class SubOne : Super { }

class SubTwo : Super { }

fun main(args: Array<String>) {

val json = Json {
    // When you type SerializersModule it sugggest the builder correctly
    serializersModule = SerializersModule {
        // but when you type polymorphic it shows only the extension located in
        // SerializersModule.kt. Even if you add the base class and close the parens,
        // it will not find or suggest the extension located in
        // the modules above. They must be pasted in manually.
        polymorphic(Super::class) {
            subclass(SubOne::class)
            subclass(SubTwo::class)
        }
    }
}
