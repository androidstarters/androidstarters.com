package <%= appPackage %>.presentation.browse

import io.reactivex.observers.DisposableSingleObserver
import <%= appPackage %>.domain.interactor.SingleUseCase
import <%= appPackage %>.domain.model.Bufferoo
import <%= appPackage %>.presentation.mapper.BufferooMapper
import javax.inject.Inject

class BrowseBufferoosPresenter @Inject constructor(val browseView: BrowseBufferoosContract.View,
                                                   val getBufferoosUseCase: SingleUseCase<List<Bufferoo>, Void>,
                                                   val bufferooMapper: BufferooMapper):
        BrowseBufferoosContract.Presenter {

    init {
        browseView.setPresenter(this)
    }

    override fun start() {
        retrieveBufferoos()
    }

    override fun stop() {
        getBufferoosUseCase.dispose()
    }

    override fun retrieveBufferoos() {
        getBufferoosUseCase.execute(BufferooSubscriber())
    }

    internal fun handleGetBufferoosSuccess(bufferoos: List<Bufferoo>) {
        browseView.hideErrorState()
        if (bufferoos.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showBufferoos(bufferoos.map { bufferooMapper.mapToView(it) })
        } else {
            browseView.hideBufferoos()
            browseView.showEmptyState()
        }
    }

    inner class BufferooSubscriber: DisposableSingleObserver<List<Bufferoo>>() {

        override fun onSuccess(t: List<Bufferoo>) {
            handleGetBufferoosSuccess(t)
        }

        override fun onError(exception: Throwable) {
            browseView.hideBufferoos()
            browseView.hideEmptyState()
            browseView.showErrorState()
        }

    }

}