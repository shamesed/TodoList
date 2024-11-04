package com.example.todolist;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {

    private static NoteDataBase instance = null;
    private static final String DB_NAME = "notes.dp";

    public static NoteDataBase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    NoteDataBase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

    public abstract NotesDao notesDao();
}
