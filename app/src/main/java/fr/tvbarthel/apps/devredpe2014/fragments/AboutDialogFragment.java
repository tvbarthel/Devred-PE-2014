package fr.tvbarthel.apps.devredpe2014.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import fr.tvbarthel.apps.devredpe2014.R;

public class AboutDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_about, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(dialogView).setCancelable(true)
                .setPositiveButton(android.R.string.ok, null);

        return builder.create();
    }
}
