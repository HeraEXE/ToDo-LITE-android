package com.hera.todo_lite.ui.edit_task

import com.hera.todo_lite.data.model.Task
import com.hera.todo_lite.data.repository.TaskRepository
import com.hera.todo_lite.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class EditTaskViewModel @Inject constructor(private val repository: TaskRepository) :
    BaseViewModel() {

        fun editTask(task: Task) {
            val disposable: Disposable = repository.editTask(task)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
            compositeDisposable.add(disposable)
        }
}