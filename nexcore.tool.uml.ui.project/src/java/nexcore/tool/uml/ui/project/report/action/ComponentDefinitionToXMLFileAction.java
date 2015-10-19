/**
 * Copyright (c) 2015 SK holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK holdings.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 */
package nexcore.tool.uml.ui.project.report.action;

import java.util.List;

import nexcore.tool.uml.core.message.UMLMessage;
import nexcore.tool.uml.ui.core.UICoreConstant;
import nexcore.tool.uml.ui.project.report.control.ReportHandler;
import nexcore.tool.uml.ui.project.report.control.impl.ComponentDefinitionReportHandler;

import org.eclipse.core.resources.IFile;
import org.eclipse.uml2.uml.Element;

/**
 * 컴포넌트 명세서 액션
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.ui.project</li>
 * <li>서브 업무명 : nexcore.tool.uml.ui.project.report.action</li>
 * <li>설 명 : ComponentDefinitionToXMLFileAction</li>
 * <li>작성일 : 2011. 8. 2.</li>
 * <li>작성자 : 황선림</li>
 * </ul>
 */
public class ComponentDefinitionToXMLFileAction extends CommonReportAction {

    /**
     * @see nexcore.tool.uml.ui.project.report.action.CommonReportAction#getDocType()
     */
    protected String getDocType() {
        return UICoreConstant.REPORT__DOCTYPE_DEFINITION;
    }

    /**
     * @see nexcore.tool.uml.ui.project.report.action.CommonReportAction#getTitle()
     */
    protected String getTitle() {
        return UMLMessage.LABEL_EXPORT_COMPONENT_DEFINITION_TO_DOC;
    }

    /**
     * @see nexcore.tool.uml.ui.project.report.action.CommonReportAction#getReportHandler(java.lang.String,
     *      org.eclipse.core.resources.IFile, java.util.List, java.lang.String)
     */
    protected ReportHandler getReportHandler(String reportLocation, IFile templateFile, List<Element> selectedPackage,
                                             String projectName) {
        // if (isValidate()) {
        return new ComponentDefinitionReportHandler(reportLocation, templateFile, selectedPackage, projectName);
        // } else {
        // return null;
        // }
    }

}
