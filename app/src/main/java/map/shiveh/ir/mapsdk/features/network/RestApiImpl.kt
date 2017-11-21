package map.shiveh.ir.mapsdk.features.network

import android.content.Context
import map.shiveh.ir.mapsdk.features.models.SampleModel
import rx.Observable
import java.io.InputStream

/**
 * Created by A.Biswas on 11/20/2017.
 */

class RestApiImpl(context: Context) : RestApi {

   private var context: Context = context


    override fun getSampleMessage(messsage: String?): Observable<SampleModel> {

        return Observable.create( { subscriber ->
            try {

                //Read the resource from Asset Folder
                

                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            if (messsage == null || "" == messsage) {
                subscriber.onError(Throwable("Not Found"))
            } else {
                val sampleModel = SampleModel(messsage)
                subscriber.onNext(sampleModel)
                subscriber.onCompleted()
            }
        })
    }
}
