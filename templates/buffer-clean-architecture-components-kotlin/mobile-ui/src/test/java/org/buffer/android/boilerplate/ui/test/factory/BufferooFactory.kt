package <%= appPackage %>.ui.test.factory

import <%= appPackage %>.domain.model.Bufferoo
import <%= appPackage %>.presentation.model.BufferooView

/**
 * Factory class for Bufferoo related instances
 */
object BufferooFactory {

    fun makeBufferooView(): BufferooView {
        return BufferooView(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid())
    }

    fun makeBufferooList(count: Int): List<Bufferoo> {
        val bufferoos = mutableListOf<Bufferoo>()
        repeat(count) {
            bufferoos.add(BufferooFactory.makeBufferooModel())
        }
        return bufferoos
    }

    fun makeBufferooModel(): Bufferoo {
        return Bufferoo(DataFactory.randomLong(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid())
    }

}