/**
 * Copyright (c) 2015 SK Holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK Holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK Holdings.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 */
package nexcore.tool.uml.ui.core;

import org.eclipse.osgi.util.NLS;

/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.ui.core</li>
 * <li>서브 업무명 : nexcore.tool.uml.ui.core</li>
 * <li>설  명 : Messages</li>
 * <li>작성일 : 2012. 3. 21.</li>
 * <li>작성자 : nspark</li>
 * </ul>
 */
public class Messages extends NLS {
    /**
     * BUNDLE_NAME
     */
    private static final String BUNDLE_NAME = "nexcore.tool.uml.ui.core.messages"; //$NON-NLS-1$

    /**
     * UMLStartupCore_AGENT_ERROR_MESSAGE
     */
    public static String UMLStartupCore_AGENT_ERROR_MESSAGE;

	/**
	 * UMLStartupCore_LICENSE_ERROR_MESSAGE
	 */
	public static String UMLStartupCore_LICENSE_ERROR_MESSAGE;

    /**
     * UMLStartupCore_LOGIN_ERROR_MESSAGE
     */
    public static String UMLStartupCore_LOGIN_ERROR_MESSAGE;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    /**
     * Messages
     */
    private Messages() {
    }
}