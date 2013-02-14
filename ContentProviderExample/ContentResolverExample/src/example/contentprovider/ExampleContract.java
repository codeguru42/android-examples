/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package example.contentprovider;

import android.net.Uri;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public final class ExampleContract {
    public static final String EXAMPLE_AUTHORITY = "example.contentprovider.provider";
    public static final String EXAMPLE_PATH = "words";
    public static final Uri EXAMPLE_URI = new Uri.Builder().scheme("content").authority(EXAMPLE_AUTHORITY).appendPath(EXAMPLE_PATH).build();
    public static final String EXAMPLE_ITEM_MIME_TYPE = "vnd.android.cursor.item/vnd.example.words";
    public static final String EXAMPLE_DIR_MIME_TYPE = "vnd.android.cursor.dir/vnd.example.words";
    public static final String WORD_COL = "word";
    public static final String[] ALL_COLS = {WORD_COL};
}
