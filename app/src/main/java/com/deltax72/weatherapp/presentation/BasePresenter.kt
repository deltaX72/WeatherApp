package com.deltax72.weatherapp.presentation

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
