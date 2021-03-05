package com.evertec.edson.ui.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class MovieItemModel : BaseObservable() {
    @Bindable
    var movieName : String = ""
    @Bindable
    var movieImage : String = ""
}