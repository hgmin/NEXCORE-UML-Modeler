/**
 * Copyright (c) 2015 SK Holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK Holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK Holdings.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 */
package nexcore.tool.uml.model.rmdata.util;

import nexcore.tool.uml.model.rmdata.RMData;
import nexcore.tool.uml.model.rmdata.RMDataPackage;
import nexcore.tool.uml.model.rmdata.RMObject;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see nexcore.tool.uml.model.rmdata.RMDataPackage
 * @generated
 */
/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.model</li>
 * <li>서브 업무명 : nexcore.tool.uml.model.rmdata.util</li>
 * <li>설  명 : RMDataAdapterFactory</li>
 * <li>작성일 : 2015. 10. 6.</li>
 * <li>작성자 : 탁희수 </li>
 * </ul>
 */
public class RMDataAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static RMDataPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public RMDataAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = RMDataPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RMDataSwitch<Adapter> modelSwitch = new RMDataSwitch<Adapter>() {
        @Override
        public Adapter caseRMData(RMData object) {
            return createRMDataAdapter();
        }

        @Override
        public Adapter caseRMObject(RMObject object) {
            return createRMObjectAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link nexcore.tool.uml.model.rmdata.RMData <em>RM Data</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see nexcore.tool.uml.model.rmdata.RMData
     * @generated
     */
    public Adapter createRMDataAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link nexcore.tool.uml.model.rmdata.RMObject <em>RM Object</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see nexcore.tool.uml.model.rmdata.RMObject
     * @generated
     */
    public Adapter createRMObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // RMDataAdapterFactory