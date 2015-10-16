/**
 * Copyright (c) 2015 SK Holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK Holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK Holdings.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 */

package nexcore.tool.uml.ui.project.explorer.action.impl;

import nexcore.tool.uml.core.message.UMLMessage;
import nexcore.tool.uml.ui.project.explorer.action.AbstractUMLExplorerExtendedAction;
import nexcore.tool.uml.ui.project.explorer.command.UMLExplorerExtendedCommand;
import nexcore.tool.uml.ui.project.explorer.command.impl.VOPCDiagramCreationCommand;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;

/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.ui.project</li>
 * <li>서브 업무명 : nexcore.tool.uml.ui.project.explorer.action.impl</li>
 * <li>설 명 : VOPCDiagramCreationAction</li>
 * <li>작성일 : 2010. 12. 2.</li>
 * <li>작성자 : 최윤석</li>
 * </ul>
 */
public class VOPCDiagramCreationAction extends AbstractUMLExplorerExtendedAction {

    /**
     * @see nexcore.tool.uml.ui.project.explorer.action.AbstractUMLExplorerExtendedAction#getTaskName()
     */
    @Override
    public String getTaskName() {
        return UMLMessage.LABEL_VOPC_DIAGRAM_CREATION;
    }

    /**
     * @see nexcore.tool.uml.ui.project.explorer.action.AbstractUMLExplorerExtendedAction#configureCommand(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public CompoundCommand configureCommand(IProgressMonitor monitor) {
        CompoundCommand compoundCommand = new CompoundCommand();

        UMLExplorerExtendedCommand command = null;
        if (getDomain() != null && getSelectedElementList() != null && getShell() != null && monitor != null) {
            command = new VOPCDiagramCreationCommand(getDomain(), getSelectedElementList(), getShell(), monitor);
        }

        compoundCommand.append(command);
        return compoundCommand;
    }

}
