/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class ExampleProvider extends ContentProvider {

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (projection.equals(ExampleContract.ALL_COLS));
        String[] words = this.getContext().getResources().getStringArray(R.array.words);
        MatrixCursor cursor = new MatrixCursor(projection, words.length);

        for (String word : words) {
            cursor.newRow().add(word);
        }

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return ExampleContract.EXAMPLE_DIR_MIME_TYPE;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
