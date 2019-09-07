package com.github.hemanthsridhar.builder;

import com.github.hemanthsridhar.pagefactory.AbstractCustomFindByBuilder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CustomPageFactoryFinder {
    Class<? extends AbstractCustomFindByBuilder> value();
}