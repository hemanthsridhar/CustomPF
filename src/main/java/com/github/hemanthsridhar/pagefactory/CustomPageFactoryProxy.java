package com.github.hemanthsridhar.pagefactory;

import com.github.hemanthsridhar.support.FilePath;
import com.github.hemanthsridhar.support.SearchAll;
import com.github.hemanthsridhar.support.SearchBy;
import com.github.hemanthsridhar.support.SearchBys;
import io.appium.java_client.pagefactory.bys.builder.ByAll;
import io.appium.java_client.pagefactory.bys.builder.ByChained;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class CustomPageFactoryProxy extends AbstractCustomFindByBuilder implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(SearchBy.class)) {

            return buildItSearchBy(method.getAnnotation(SearchBy.class), method.getName(),
                    method.getDeclaringClass().getAnnotation(FilePath.class).value());
        } else if (method.isAnnotationPresent(SearchAll.class)) {

            return buildItSearchAll(method.getAnnotation(SearchAll.class),
                    method.getDeclaringClass().getAnnotation(FilePath.class).value());
        }
        else if(method.isAnnotationPresent(SearchBys.class)){

            return buildItSearchBys(method.getAnnotation(SearchBys.class),
            method.getDeclaringClass().getAnnotation(FilePath.class).value());
        }
        else {
            throw new Exception("Unsupported Annotation. Please use SearchBy, SearchBys, SearchAll.");
        }
    }

    private By buildItSearchAll(SearchAll findBys, String filePath) {
        SearchBy[] findByArray = findBys.value();
        By[] byArray = new By[findByArray.length];
        for (int i = 0; i < findByArray.length; i++) {
            byArray[i] = buildByFromShortFindBy(findByArray[i], findByArray[i].nameOfTheLocator(), filePath);
        }
        return new ByAll(byArray);
    }

    public By buildItSearchBy(SearchBy annotation, String field, String filePath) {
        if(annotation.nameOfTheLocator().trim().equals("")) {
            return buildByFromShortFindBy(annotation, field, filePath);
        }
        else{
            return buildByFromShortFindBy(annotation, annotation.nameOfTheLocator(), filePath);
        }
    }

    public By buildItSearchBys(SearchBys findBys, String filePath) {
        SearchBy[] findByArray = findBys.value();
        By[] byArray = new By[findByArray.length];
        for (int i = 0; i < findByArray.length; i++) {
            byArray[i] = buildByFromShortFindBy(findByArray[i], findByArray[i].nameOfTheLocator(), filePath);
        }
        return new ByChained(byArray);
    }

    @Override
    public By buildIt(Object annotation, Field field, String filePath) {
        return null;
    }
}
