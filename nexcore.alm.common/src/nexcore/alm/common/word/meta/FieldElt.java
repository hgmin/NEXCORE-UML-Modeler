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
// Generated on: 2008.04.16 at 03:25:25 ���� KST
//

package nexcore.alm.common.word.meta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for FieldElt complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;FieldElt&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref=&quot;{http://skcc.com/2003/wordmeta}Class&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;name&quot; type=&quot;{http://skcc.com/2003/wordmeta}type&quot; /&gt;
 *       &lt;attribute name=&quot;field&quot; type=&quot;{http://skcc.com/2003/wordmeta}type&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldElt", propOrder = { "clazz" })
public class FieldElt {

    @XmlElement(name = "Class")
    protected ClassElt clazz;

    @XmlAttribute(namespace = "http://skcc.com/2003/wordmeta")
    protected String name;

    @XmlAttribute(namespace = "http://skcc.com/2003/wordmeta")
    protected String field;

    /**
     * Gets the value of the clazz property.
     * 
     * @return possible object is {@link ClassElt }
     * 
     */
    public ClassElt getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *            allowed object is {@link ClassElt }
     * 
     */
    public void setClazz(ClassElt value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the field property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the value of the field property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setField(String value) {
        this.field = value;
    }

}
