package <%= appPackage %>.domain.interactor.browse

import io.reactivex.Single
import <%= appPackage %>.domain.executor.PostExecutionThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.interactor.SingleUseCase
import <%= appPackage %>.domain.model.Bufferoo
import <%= appPackage %>.domain.repository.BufferooRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class GetBufferoos @Inject constructor(val bufferooRepository: BufferooRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Bufferoo>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Bufferoo>> {
        return bufferooRepository.getBufferoos()
    }

}