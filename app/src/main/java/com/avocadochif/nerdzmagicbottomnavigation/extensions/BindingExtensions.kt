package com.avocadochif.nerdzmagicbottomnavigation.extensions

import androidx.databinding.ViewDataBinding

fun ViewDataBinding.bindData(variableId: Int, value: Any?) {
    this.setVariable(variableId, value)
    this.executePendingBindings()
}