package com.example.contentprovider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import com.example.contentprovider.PersonContract.PersonEntry.TABLE_NAME

class PersonProvider : ContentProvider() {
    private lateinit var database : SQLiteDatabase

    override fun onCreate(): Boolean {
        if(context == null) return false
        database = DatabaseHelper.getInstance(context!!).writableDatabase

        return true
    }

    override fun query(
        uri: Uri,
        projcetion: Array<out String>?,
        selection: String?,
        selctionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        var cursor: Cursor? = null
        when(uriMatcher.match(uri)){
            PERSONS -> {
                cursor = database.query(TABLE_NAME, projcetion, selection, selctionArgs, null, null, sortOrder)
            }
            else -> throw IllegalArgumentException("알 수 없는 URI : $uri")
        }

        //cursor.setNotificationUri(context?.contentResolver, uri)
        return cursor
    }

    override fun getType(uri: Uri): String? {
        when(uriMatcher.match(uri)){
            PERSONS -> return "vnd.android.cursor.dir/persons"
            else -> throw IllegalArgumentException("알 수 없는 URI : $uri")
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val id = database.insert(TABLE_NAME, null, values)

        if(id > 0){
            val uri = ContentUris.withAppendedId(CONTENT_URI, id)
            context?.contentResolver?.notifyChange(uri, null)
            return uri
        }

        throw SQLException("추가 실패 URI : $uri")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        var count = 0
        when(uriMatcher.match(uri)){
            PERSONS -> count = database.delete(TABLE_NAME, selection, selectionArgs)
            else -> throw IllegalArgumentException("알 수 없는 URI : $uri")
        }
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        var count = 0
        when(uriMatcher.match(uri)){
            PERSONS -> count = database.update(TABLE_NAME, values, selection, selectionArgs)
            else -> throw IllegalArgumentException("알 수 없는 URI : $uri")
        }
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }

    companion object{
        const val AUTHORITY = "com.example.contentprovider"
        const val BASE_PATH = "person"
        val CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH)

        const val PERSONS = 1
        const val PERSON_ID = 2

        val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, BASE_PATH, PERSONS)
            addURI(AUTHORITY, BASE_PATH + "/#", PERSON_ID)
        }
    }
}