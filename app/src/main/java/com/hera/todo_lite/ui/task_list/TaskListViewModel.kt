package com.hera.todo_lite.ui.task_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hera.todo_lite.data.model.Task
import com.hera.todo_lite.data.repository.TaskRepository
import com.hera.todo_lite.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(private val repository: TaskRepository) :
    BaseViewModel() {

    private val _allTasks: MutableLiveData<List<Task>> = MutableLiveData()
    val allTasks: LiveData<List<Task>> get() = _allTasks

    fun getAllTasks() {
        val disposable: Disposable = repository.getAllTasks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    _allTasks.value = it
                },
                onError = {
                    it.printStackTrace()
                }
            )
        compositeDisposable.add(disposable)
    }

    fun editTask(task: Task) {
        val disposable: Disposable = repository.editTask(task)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        compositeDisposable.add(disposable)
    }
}