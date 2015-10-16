/**
 * Copyright (c) 2015 SK Holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK Holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK Holdings.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, vJAXB 2.1.3 in JDK 1.6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2008.04.16 at 03:26:38 ���� KST
//

package nexcore.alm.common.word.meta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.skcc.common.word.meta package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Key_QNAME = new QName("http://skcc.com/2003/wordmeta", "Key");

    private final static QName _Class_QNAME = new QName("http://skcc.com/2003/wordmeta", "Class");

    private final static QName _TemplateMeta_QNAME = new QName("http://skcc.com/2003/wordmeta", "TemplateMeta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.skcc.common.word.meta
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TemplateMetaElt }
     * 
     */
    public TemplateMetaElt createTemplateMetaElt() {
        return new TemplateMetaElt();
    }

    /**
     * Create an instance of {@link ClassElt }
     * 
     */
    public ClassElt createClassElt() {
        return new ClassElt();
    }

    /**
     * Create an instance of {@link KeyElt }
     * 
     */
    public KeyElt createKeyElt() {
        return new KeyElt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyElt }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://skcc.com/2003/wordmeta", name = "Key")
    public JAXBElement<KeyElt> createKey(KeyElt value) {
        return new JAXBElement<KeyElt>(_Key_QNAME, KeyElt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassElt }{@code
     * >}
     * 
     */
    @XmlElementDecl(namespace = "http://skcc.com/2003/wordmeta", name = "Class")
    public JAXBElement<ClassElt> createClass(ClassElt value) {
        return new JAXBElement<ClassElt>(_Class_QNAME, ClassElt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemplateMetaElt }
     * {@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://skcc.com/2003/wordmeta", name = "TemplateMeta")
    public JAXBElement<TemplateMetaElt> createTemplateMeta(TemplateMetaElt value) {
        return new JAXBElement<TemplateMetaElt>(_TemplateMeta_QNAME, TemplateMetaElt.class, null, value);
    }

}
