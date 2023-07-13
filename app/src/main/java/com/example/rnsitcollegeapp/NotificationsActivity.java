package com.example.rnsitcollegeapp;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationsActivity extends AppCompatActivity {

    private static final String TAG = "GroupChatActivity";
    private EditText messageInput;
    private Button sendButton;
    private ListView messageListView;
    private MessageAdapter messageAdapter;

    private DatabaseReference messagesRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        getWindow().setStatusBarColor(ContextCompat.getColor(NotificationsActivity.this,R.color.darkblue));
        if(getSupportActionBar()!=null) {
            (getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darkblue)));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Queries Section</font>"));
        }

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        messagesRef = database.getReference("group_chat_messages");

        // Get views
        messageInput = findViewById(R.id.adminNotificationsNotify);
        sendButton = findViewById(R.id.button);
        messageListView = findViewById(R.id.list_view_messages);

        // Initialize message adapter and attach it to the list view
        List<String> messages = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, messages);
        messageListView.setAdapter(messageAdapter);

        // Send button click listener
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageInput.getText().toString();
                if (!message.isEmpty()) {
                    sendMessage(message);
                    messageInput.setText("");
                }
            }
        });

        // Listen for new messages
        messagesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    if (dataSnapshot.getValue() != null) {
                        String message = dataSnapshot1.getValue().toString();
                        Log.d(TAG, "New message: " + message);
                        messageAdapter.addMessage(message);
                        messageListView.smoothScrollToPosition(messageAdapter.getCount() - 1);
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                // Called when an existing message is modified
                // You can handle any updates or changes to the messages here
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // Called when a message is removed or deleted
                // You can handle the removal of messages here
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                // Called when a message changes position in the list
                // You can handle any changes in message order here
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Called when there is an error in accessing the database
                // You can handle the error condition here
                Log.e(TAG, "Database error: " + databaseError.getMessage());
            }
        });
    }

    private void sendMessage(String message) {
        DatabaseReference newMessageRef = messagesRef.push();
        Map<String, Object> messageMap = new HashMap<>();
        messageMap.put("text", message);
        newMessageRef.setValue(messageMap);
    }
}
