package map.shiveh.ir.mapsdk.features.repository.network

import android.content.Context

import map.shiveh.ir.mapsdk.features.models.SampleModel
import map.shiveh.ir.mapsdk.features.network.RestApi
import map.shiveh.ir.mapsdk.features.network.RestApiImpl
import rx.Observable

/**
 * Created by A.Biswas on 11/20/2017.
 */

class NetworkRepository(context: Context) : INetworkRepository {

    private var restApi: RestApi? = null

    init {
        restApi = RestApiImpl(context)
    }

    override fun getSampleMessage(messsage: String?): Observable<SampleModel> {
        return restApi!!.getSampleMessage(messsage)
    }
}
