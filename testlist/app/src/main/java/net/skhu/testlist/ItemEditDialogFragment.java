package net.skhu.testlist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;

public class ItemEditDialogFragment extends DialogFragment {
    
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final MainActivity activity = (MainActivity)getActivity();
        final Item item = activity.itemList.get(activity.selectedIndex);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("수정");
        
        final View rootView = activity.getLayoutInflater().inflate(R.layout.item_edit, null);
        final EditText editText_title = (EditText)rootView.findViewById(R.id.editText_title);
        final EditText editText_createDate = (EditText)rootView.findViewById(R.id.editText_createTime);
        
        editText_title.setText(item.getTitle());
        editText_createDate.setText(item.getCreateTimeFormatted());
        
        builder.setView(rootView);
        
        builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CharSequence s1 = editText_title.getText();
                CharSequence s2 = editText_createDate.getText();
                
                item.setTitle(s1.toString());
                item.setCreateTimeFormatted(s2.toString());
                activity.firebaseDbService.updataInServer(activity.selectedIndex);
            }
        });
        
        builder.setNegativeButton("취소", null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
