package com.example.rnsitcollegeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<String> {

    private List<String> messages;
    private LayoutInflater inflater;

    public MessageAdapter(Context context, List<String> messages) {
        super(context, 0, messages);
        this.messages = messages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_message, parent, false);
            holder = new ViewHolder();
            holder.messageTextView = convertView.findViewById(R.id.text_view_message);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String message = messages.get(position);
        holder.messageTextView.setText(message);

        return convertView;
    }

    public void addMessage(String message) {
        messages.add(message);
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        TextView messageTextView;
    }
}

