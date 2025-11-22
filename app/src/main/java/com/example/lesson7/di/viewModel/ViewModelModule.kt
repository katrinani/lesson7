package com.example.lesson7.di.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lesson7.presenter.MainViewModel
import com.example.lesson7.presenter.create.CreateVieModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(
        factory: ViewModeFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(
        viewModel: MainViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateVieModel::class)
    fun bindCreateTaskUseCase (
        vieModel: CreateVieModel
    ): ViewModel

}