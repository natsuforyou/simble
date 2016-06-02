package org.simble.framework.mybatis.plugins;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

public class XmlFileOverwritePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMapFile, IntrospectedTable introspectedTable) {
        String overwrite = context.getProperty("overwrite");
        if ("true".equals(overwrite)) {
            try {
                Field mergedField = GeneratedXmlFile.class.getDeclaredField("isMergeable");
                mergedField.setAccessible(true);
                mergedField.setBoolean(sqlMapFile, false);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.sqlMapGenerated(sqlMapFile, introspectedTable);
    }
}
