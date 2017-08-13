package <%= appPackage %>.data

import io.reactivex.Completable
import io.reactivex.Single
import <%= appPackage %>.data.mapper.BufferooMapper
import <%= appPackage %>.data.model.BufferooEntity
import <%= appPackage %>.data.source.BufferooDataStoreFactory
import <%= appPackage %>.domain.model.Bufferoo
import <%= appPackage %>.domain.repository.BufferooRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [BufferooRepository] interface for communicating to and from
 * data sources
 */
class BufferooDataRepository @Inject constructor(private val factory: BufferooDataStoreFactory,
                                                 private val bufferooMapper: BufferooMapper):
        BufferooRepository {

    override fun clearBufferoos(): Completable {
        return factory.retrieveCacheDataStore().clearBufferoos()
    }

    override fun saveBufferoos(bufferoos: List<Bufferoo>): Completable {
        val bufferooEntities = mutableListOf<BufferooEntity>()
        bufferoos.map { bufferooEntities.add(bufferooMapper.mapToEntity(it)) }
        return factory.retrieveCacheDataStore().saveBufferoos(bufferooEntities)
    }

    override fun getBufferoos(): Single<List<Bufferoo>> {
        return factory.retrieveDataStore().getBufferoos()
                .flatMap {
                    val bufferoos = mutableListOf<Bufferoo>()
                    it.map { bufferoos.add(bufferooMapper.mapFromEntity(it)) }
                    saveBufferoos(bufferoos)
                            .andThen(Single.just(bufferoos))
                }

    }

}