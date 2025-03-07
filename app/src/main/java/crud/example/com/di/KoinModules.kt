package crud.example.com.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import crud.example.com.database.ToDoDatabase
import crud.example.com.repositories.TodoRepository
import crud.example.com.ui.viewmodels.HomeViewModel
import crud.example.com.ui.viewmodels.CreateViewModel
import crud.example.com.ui.viewmodels.EditViewModel

val appModule = module {
    singleOf(::TodoRepository)
    viewModelOf(::HomeViewModel)
    viewModelOf(::CreateViewModel)
    viewModelOf(::EditViewModel)
}

val storageModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            ToDoDatabase::class.java, "taks_database.db"
        ).build()
    }
    single { get<ToDoDatabase>().todoDao() }
}