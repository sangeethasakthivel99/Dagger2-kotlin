package com.sangeetha.dagger2.features.Login.view.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.sangeetha.dagger2.R
import com.sangeetha.dagger2.features.Login.viewmodels.LoginActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var appLogo: Drawable

  @Inject
  lateinit var mRequestManager: RequestManager

  private lateinit var mLoginActivityViewModel: LoginActivityViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
    initViewModel()

    setLogo()
  }

  private fun initViewModel() {
    mLoginActivityViewModel = ViewModelProviders.of(this , viewModelFactory).get(LoginActivityViewModel::class.java)
  }

  private fun setLogo() {
    mRequestManager
       .load(appLogo)
       .into(app_logo)
  }

}
