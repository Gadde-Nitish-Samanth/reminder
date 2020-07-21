package com.example.reminder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText editTextnotename,editTextnote,editTextdate,editTexttime;
    private ExampleDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog,null );
        builder.setView(view)
                .setTitle("New Note")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }

                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface,int t){
                        String note_name = editTextnotename.getText().toString();
                        String note = editTextnote.getText().toString();
                        String date = editTextdate.getText().toString();
                        String time = editTexttime.getText().toString();
                        listener.applyTexts(note_name,note,date,time);

                    }
                });
        editTextnotename = view.findViewById(R.id.edit_notename);
        editTextnote = view.findViewById(R.id.edit_note);
        editTextdate = view.findViewById(R.id.editDate);
        editTexttime = view.findViewById(R.id.editTime);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener = (ExampleDialogListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ " must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String notename,String note,String date,String time);
    }
}
