package <%= appPackage %>.presentation.browse

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.subscribers.DisposableSubscriber
import <%= appPackage %>.domain.interactor.browse.GetBufferoos
import <%= appPackage %>.domain.model.Bufferoo
import <%= appPackage %>.presentation.data.Resource
import <%= appPackage %>.presentation.data.ResourceState
import <%= appPackage %>.presentation.mapper.BufferooMapper
import <%= appPackage %>.presentation.model.BufferooView
import javax.inject.Inject

open class BrowseBufferoosViewModel @Inject internal constructor(
        private val getBufferoos: GetBufferoos,
        private val bufferooMapper: BufferooMapper) : ViewModel() {

    private val bufferoosLiveData: MutableLiveData<Resource<List<BufferooView>>> =
            MutableLiveData()

    init {
        fetchBufferoos()
    }

    override fun onCleared() {
        getBufferoos.dispose()
        super.onCleared()
    }

    fun getBufferoos(): LiveData<Resource<List<BufferooView>>> {
        return bufferoosLiveData
    }

    fun fetchBufferoos() {
        bufferoosLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBufferoos.execute(BufferooSubscriber())
    }

    inner class BufferooSubscriber: DisposableSubscriber<List<Bufferoo>>() {

        override fun onComplete() { }

        override fun onNext(t: List<Bufferoo>) {
            bufferoosLiveData.postValue(Resource(ResourceState.SUCCESS,
                    t.map { bufferooMapper.mapToView(it) }, null))
        }

        override fun onError(exception: Throwable) {
            bufferoosLiveData.postValue(Resource(ResourceState.ERROR, null, exception.message))
        }

    }

}