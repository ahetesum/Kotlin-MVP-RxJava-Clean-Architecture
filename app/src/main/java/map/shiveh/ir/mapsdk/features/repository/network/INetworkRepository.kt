package map.shiveh.ir.mapsdk.features.repository.network

import map.shiveh.ir.mapsdk.features.models.SampleModel
import rx.Observable

/**
 * Created by A.Biswas on 11/20/2017.
 */

interface INetworkRepository {
    fun getSampleMessage(messsage: String?): Observable<SampleModel>
}
