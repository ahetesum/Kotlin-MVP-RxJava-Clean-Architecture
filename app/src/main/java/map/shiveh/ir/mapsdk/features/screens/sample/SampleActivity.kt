package map.shiveh.ir.mapsdk.features.screens.sample

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import map.shiveh.ir.mapsdk.R

import kotlinx.android.synthetic.main.activity_sample.*
import kotlinx.android.synthetic.main.content_sample.*
import map.shiveh.ir.mapsdk.features.models.SampleModel

class SampleActivity : AppCompatActivity(), View.OnClickListener, SampleView {



    lateinit var samplePresenter: SamplePresenter
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)
        init()
    }


    override fun init() {
        samplePresenter= SamplePresenter(this)
        sendMessageButton.setOnClickListener(this)
    }

    override fun getContext(): Context = this

    override fun showLoadingDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog.show(this, "", "Loading..", true, false)
        } else {
            mProgressDialog?.show()
        }
    }

    override fun hideLoadingDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.hide()
        }
    }

    override fun updateView(sampleModel: SampleModel) {
        Toast.makeText(applicationContext, "Your Message is-> "+ sampleModel.message, Toast.LENGTH_SHORT).show()
    }

    override fun getMessage(): String {
        return  messageEditText.text.toString()
    }

    override fun showError(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    override  fun onClick(v: View?) {
        when(v)
        {
            sendMessageButton -> {
                samplePresenter.getSampleMessage(getMessage())}
        }
    }
}
