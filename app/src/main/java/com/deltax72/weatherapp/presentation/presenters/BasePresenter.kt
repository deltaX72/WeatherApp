package com.deltax72.weatherapp.presentation.presenters

import com.deltax72.weatherapp.presentation.viewmodels.BaseView

open class BasePresenter<T: BaseView> {
    var view: T? = null

    fun attachView(view: T) {
        this.view = view
        this.onViewAttached()
    }

    open fun onViewAttached() {}

    fun detachView() {
        this.view = null
    }
}
