package com.example.lesson7.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson7.data.model.TaskEntity
import com.example.lesson7.databinding.TitemTaskBinding
import java.text.SimpleDateFormat
import java.util.Locale

class TasksAdapter(
    private val onTaskChangeClick: (TaskEntity) -> Unit,
): ListAdapter<TaskEntity, TasksAdapter.TaskViewHolder>(TasksDiffUtil()) {

    class TaskViewHolder(
        private val onTaskChangeClick: (TaskEntity) -> Unit,
        private val binding: TitemTaskBinding,
    ): ViewHolder(binding.root) {

        fun bind(task: TaskEntity) = with(binding) {
            val formater = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

            itemTaskTitle.text = task.title
            itemTaskDescription.text = task.description
            itemTasStatus.text = task.state.name
            itemTasStatus.setOnClickListener {
                onTaskChangeClick(task)
            }

            itemTaskStartTime.text = formater.format(task.startTime)
            itemTaskEndTime.text = formater.format(task.endTime)
        }

    }

    private class TasksDiffUtil: ItemCallback<TaskEntity> () {
        override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean =
            oldItem == newItem


        override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val binding = TitemTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(
            onTaskChangeClick,
            binding,
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}