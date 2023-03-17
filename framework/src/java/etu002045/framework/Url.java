package etu002045.framework;

import java.lang.annotation.*;

@Retention( RetentionPolicy.RUNTIME )
// @Target( ElementType.TYPE )
public @interface Url {
    String name() default "";
}

