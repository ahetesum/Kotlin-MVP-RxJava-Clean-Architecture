package map.shiveh.ir.mapsdk.features.screens.sample

import map.shiveh.ir.mapsdk.features.models.SampleModel
import map.shiveh.ir.mapsdk.features.repository.network.NetworkRepository
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Ahetesum
 */
class SamplePresenter(private val sampleView: SampleView) {

    private val repository : NetworkRepository

    init {
        repository= NetworkRepository(sampleView.getContext())
    }

    fun getSampleMessage(message: String) {
        sampleView.showLoadingDialog()
        repository.getSampleMessage(message).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Subscriber<SampleModel>() {

            override fun onCompleted() {
                sampleView.hideLoadingDialog()
            }

            override fun onError(e: Throwable) {
                this@SamplePresenter.onError(e.message!!)
            }

            override fun onNext(sampleModel: SampleModel) {
                onSuccess(sampleModel)
            }
        })
    }

    fun onError(msg: String) {
        sampleView.hideLoadingDialog()
        sampleView.showError(msg)
    }

    fun onSuccess(sampleModel: SampleModel) {
        sampleView.hideLoadingDialog()
        sampleView.updateView(sampleModel)
    }
}
