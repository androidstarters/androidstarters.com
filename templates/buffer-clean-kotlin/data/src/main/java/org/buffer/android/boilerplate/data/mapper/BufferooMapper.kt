package <%= appPackage %>.data.mapper

import <%= appPackage %>.data.model.BufferooEntity
import <%= appPackage %>.domain.model.Bufferoo
import javax.inject.Inject


/**
 * Map a [BufferooEntity] to and froma a [Bufferoo] instance when data is moving between
 * this later and the Domain layer
 */
class BufferooMapper @Inject constructor(): Mapper<BufferooEntity, Bufferoo> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: BufferooEntity): Bufferoo {
        return Bufferoo(type.name, type.title, type.avatar)
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: Bufferoo): BufferooEntity {
        return BufferooEntity(type.name, type.title, type.avatar)
    }


}