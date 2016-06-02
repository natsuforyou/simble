package org.simble.framework.mybatis.plugins;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class PessimisticLockPluginMysql extends PessimisticLockPlugin {
    @Override
    protected void generateLimitElement(XmlElement parentElement) {
        XmlElement limit = new XmlElement("if");
        limit.addAttribute(new Attribute("test", "limitStart >= 0"));
        limit.addElement(new TextElement(" limit #{limitStart} , #{limitEnd} "));
        parentElement.addElement(limit);
    }
}
