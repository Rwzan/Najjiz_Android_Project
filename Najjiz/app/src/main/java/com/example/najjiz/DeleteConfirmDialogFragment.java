package com.example.najjiz;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * Confirmation dialog shown before a task is permanently deleted.
 * Used by MyTasksActivity, as planned in Phase 1 (Android Components Plan).
 */
public class DeleteConfirmDialogFragment extends DialogFragment {

    private static final String ARG_TASK_ID = "task_id";
    private static final String ARG_TASK_TITLE = "task_title";

    /** Callback used to notify the hosting Activity that deletion was confirmed. */
    public interface OnDeleteConfirmedListener {
        void onDeleteConfirmed(int taskId);
    }

    private OnDeleteConfirmedListener listener;

    public static DeleteConfirmDialogFragment newInstance(int taskId, String taskTitle) {
        DeleteConfirmDialogFragment fragment = new DeleteConfirmDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TASK_ID, taskId);
        args.putString(ARG_TASK_TITLE, taskTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public void setOnDeleteConfirmedListener(OnDeleteConfirmedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int taskId = getArguments() != null ? getArguments().getInt(ARG_TASK_ID) : -1;
        String taskTitle = getArguments() != null ? getArguments().getString(ARG_TASK_TITLE) : "";

        return new AlertDialog.Builder(requireActivity())
                .setTitle(R.string.delete_confirm_title)
                .setMessage(getString(R.string.delete_confirm_message) + "\n\n\"" + taskTitle + "\"")
                .setPositiveButton(R.string.yes, (dialog, which) -> {
                    if (listener != null) {
                        listener.onDeleteConfirmed(taskId);
                    }
                })
                .setNegativeButton(R.string.no, (dialog, which) -> dismiss())
                .create();
    }
}
