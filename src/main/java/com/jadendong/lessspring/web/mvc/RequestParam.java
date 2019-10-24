package com.jadendong.lessspring.web.mvc;

import java.lang.annotation.*;

/**
 * @author jaden
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RequestParam {
    String value();
}
