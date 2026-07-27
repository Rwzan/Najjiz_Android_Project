package com.example.najjiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Binds the list of Task objects to CardView rows inside the RecyclerView
 * shown on MyTasksActivity.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    /** Callback used to notify MyTasksActivity when the user taps "Delete" on a card. */
    public interface OnTaskDeleteClickListener {
        void onDeleteClick(Task task);
    }

    private final List<Task> taskList;
    private final OnTaskDeleteClickListener deleteClickListener;

    public TaskAdapter(List<Task> taskList, OnTaskDeleteClickListener deleteClickListener) {
        this.taskList = taskList;
        this.deleteClickListener = deleteClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.title.setText(task.getTitle());
        holder.priority.setText(holder.itemView.getContext()
                .getString(R.string.priority_label) + " " + task.getPriority());

        switch (task.getPriority() == null ? "" : task.getPriority()) {
            case "High":
                holder.priority.setTextColor(holder.itemView.getResources().getColor(R.color.priority_high));
                break;
            case "Low":
                holder.priority.setTextColor(holder.itemView.getResources().getColor(R.color.priority_low));
                break;
            default:
                holder.priority.setTextColor(holder.itemView.getResources().getColor(R.color.priority_medium));
                break;
        }

        holder.deleteButton.setOnClickListener(v -> {
            if (deleteClickListener != null) {
                deleteClickListener.onDeleteClick(task);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView priority;
        TextView deleteButton;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_task_title);
            priority = itemView.findViewById(R.id.text_task_priority);
            deleteButton = itemView.findViewById(R.id.text_delete);
        }
    }
}
