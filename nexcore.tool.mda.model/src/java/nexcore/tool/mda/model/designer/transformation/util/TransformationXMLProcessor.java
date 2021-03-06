/**
 * Copyright (c) 2015 SK holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK holdings.
 * (http://www.eclipse.org/legal/epl-v10.html)
 */

package nexcore.tool.mda.model.designer.transformation.util;

import java.util.Map;

import nexcore.tool.mda.model.designer.transformation.TransformationPackage;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TransformationXMLProcessor extends XMLProcessor {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public TransformationXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        TransformationPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the
     * TransformationResourceFactoryImpl factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new TransformationResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new TransformationResourceFactoryImpl());
        }
        return registrations;
    }

} // TransformationXMLProcessor
