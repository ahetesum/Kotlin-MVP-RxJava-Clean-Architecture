package map.shiveh.ir.mapsdk.features.screens.sample


import map.shiveh.ir.mapsdk.app.base.AppView
import map.shiveh.ir.mapsdk.features.models.SampleModel

/**
 * Created by Ahetesum
 */
interface SampleView :AppView{
    fun getMessage() : String
    fun updateView(sampleModel: SampleModel)
}
