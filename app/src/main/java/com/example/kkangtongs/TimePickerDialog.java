package com.example.kkangtongs;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerDialog extends Dialog {

    private Context context;
    private TimePickerDialogListener timePickerDialogListener;
    private TimePicker timePicker;

    private TextView positiveBtn, cancelBtn;


    public TimePickerDialog(Context context, TimePickerDialogListener timePickerDialogListener) {
        super(context);

        this.context = context;
        this.timePickerDialogListener = timePickerDialogListener;
    }

    public int getHour() {
        return timePicker.getHour();
    }

    public int getMinute() {
        return timePicker.getMinute();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_timepicker);

        timePicker = (TimePicker) findViewById(R.id.timepicker_alert_two);
        timePicker.setIs24HourView(true);

        positiveBtn = findViewById(R.id.time_yes_btn);
        cancelBtn = findViewById(R.id.time_no_btn);

        positiveBtn.setOnClickListener(view -> {
            this.timePickerDialogListener.onPositiveClick(getHour(), getMinute());
            dismiss();
        });

        cancelBtn.setOnClickListener(view -> {
            this.timePickerDialogListener.onCancelClick();
            dismiss();
        });

    }
}
