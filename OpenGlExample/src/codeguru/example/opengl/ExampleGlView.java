/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
package codeguru.example.opengl;

import android.opengl.GLSurfaceView;

/**
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class ExampleGlView extends GLSurfaceView {
    
    public ExampleGlView(Context context) {
        super(context);
        
        this.setRenderer(new ExampleGlRenderer());
    }
    
}
