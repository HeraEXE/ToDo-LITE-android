package com.hera.todo_lite.ui.create_task

import com.hera.todo_lite.data.model.Task
import com.hera.todo_lite.data.repository.TaskRepository
import com.hera.todo_lite.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : BaseViewModel() {

    fun createTask(task: Task) {
        val disposable: Disposable = taskRepository.addTask(task)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        compositeDisposable.add(disposable)
    }
}