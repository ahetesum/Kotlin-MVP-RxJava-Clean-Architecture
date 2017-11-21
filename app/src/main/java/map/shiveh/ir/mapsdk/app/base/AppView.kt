package map.shiveh.ir.mapsdk.app.base

import android.content.Context

/**
 * Created by A.Biswas on 11/20/2017.
 */

interface AppView
{
    fun init()

    fun getContext(): Context

    fun showLoadingDialog()

    fun hideLoadingDialog()

    fun showError(msg: String)
}
