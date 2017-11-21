package map.shiveh.ir.mapsdk.features.network


import map.shiveh.ir.mapsdk.features.models.SampleModel
import rx.Observable

/**
 * Created by studyjun on 2016/3/2.
 */
interface RestApi {

    fun getSampleMessage(messsage: String?): Observable<SampleModel>

}
