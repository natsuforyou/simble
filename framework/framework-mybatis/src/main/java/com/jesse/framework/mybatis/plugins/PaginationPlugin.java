/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.mybatis.plugins;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jesse Qian on 16-5-13.
 */
public class PaginationPlugin extends PluginAdapter {
    private final static String OFFSET = "offset";
    private final static String LIMIT = "limit";

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        addElements(element);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        addElements(element);
        return super.sqlMapExampleWhereClauseElementGenerated(element, introspectedTable);
    }

    private void addElements(XmlElement parentElement) {
        parentElement.addElement(createElements(OFFSET));
        parentElement.addElement(createElements(LIMIT));
    }

    private XmlElement createElements(String attribute) {
        XmlElement element = new XmlElement("if");
        element.addAttribute(new Attribute("test", attribute + " gt 0"));
        element.addElement(new TextElement(attribute + " #{" + attribute + "}"));
        return element;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String[] offsetJavaDoc = new String[] { "@param " + OFFSET + " ", " e.g. " + OFFSET + " = 5 " + LIMIT + " = 10", "  " };
        String[] limitJavaDoc = new String[] { "@param " + LIMIT + " ", " e.g. " + OFFSET + " = 5 " + LIMIT + " = 10", " " };
        initField(topLevelClass, OFFSET, FullyQualifiedJavaType.getIntInstance(), offsetJavaDoc);
        initField(topLevelClass, LIMIT, FullyQualifiedJavaType.getIntInstance(), limitJavaDoc);
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    private void initField(TopLevelClass topLevelClass, String fieldName, FullyQualifiedJavaType type, String... javaDocLines) {
        topLevelClass.addField(createField(fieldName, type));
        List<String> setLines = Arrays.asList("this." + fieldName + " = " + fieldName + ";");
        List<String> getLines = Arrays.asList("return " + fieldName + ";");
        Method setMethod = createMethod("set" + StringUtils.capitalize(fieldName), null, new Parameter(type, fieldName), setLines, javaDocLines);
        Method getMethod = createMethod("get" + StringUtils.capitalize(fieldName), type, null, getLines);
        topLevelClass.addMethod(setMethod);
        topLevelClass.addMethod(getMethod);
    }

    private Field createField(String name, FullyQualifiedJavaType type) {
        Field field = new Field(name, type);
        field.setVisibility(JavaVisibility.PRIVATE);
        return field;
    }

    private Method createMethod(String name, FullyQualifiedJavaType returnType, Parameter parameter, List<String> lines, String... javaDocLines) {
        Method method = new Method(name);
        method.setVisibility(JavaVisibility.PUBLIC);
        if (returnType != null)
            method.setReturnType(returnType);
        if (parameter != null)
            method.addParameter(parameter);
        if (lines != null)
            method.addBodyLines(lines);
        if (javaDocLines != null)
            addMethodComment(method, javaDocLines);
        return method;
    }

    private void addMethodComment(Method method, String... javaDocLines) {
        method.addJavaDocLine("/**");
        if (javaDocLines != null)
            for (String javaDocLine : javaDocLines)
                method.addJavaDocLine(" * " + javaDocLine);
        method.addJavaDocLine(" */");
    }
}
