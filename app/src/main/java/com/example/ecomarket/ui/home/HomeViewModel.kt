package com.example.ecomarket.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomarket.repository.Repository
import com.example.ecomarket.data.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val categoryResponse: MutableLiveData<Response<Category>> = MutableLiveData()
    fun getCategories() {
        viewModelScope.launch {
            val response = repository.getCategories()
            categoryResponse.value = response
        }
    }
}