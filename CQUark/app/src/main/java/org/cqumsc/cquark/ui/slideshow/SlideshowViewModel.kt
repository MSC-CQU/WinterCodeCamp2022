package org.cqumsc.cquark.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.cqumsc.cquark.front_net.ExamApi

class SlideshowViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getExamInfo()
    }

    //需要改动
    private fun getExamInfo() {
        viewModelScope.launch {
            try {
                val listResult = ExamApi.retrofitService.getInfo()
                val separator = "-"
                _response.value = listResult.joinToString()
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}