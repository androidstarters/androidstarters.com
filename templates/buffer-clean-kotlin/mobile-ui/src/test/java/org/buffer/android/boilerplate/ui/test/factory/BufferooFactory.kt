package <%= appPackage %>.ui.test.factory

import <%= appPackage %>.presentation.model.BufferooView
import <%= appPackage %>.ui.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooView(): BufferooView {
            return BufferooView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}