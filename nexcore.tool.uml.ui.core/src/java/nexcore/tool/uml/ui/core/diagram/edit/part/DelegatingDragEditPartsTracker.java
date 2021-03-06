/**
 * Copyright (c) 2015 SK holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK holdings.
 * (http://www.eclipse.org/legal/epl-v10.html)
 */

package nexcore.tool.uml.ui.core.diagram.edit.part;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.swt.events.MouseEvent;

/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.ui.core</li>
 * <li>서브 업무명 : nexcore.tool.uml.ui.core.diagram.edit.part</li>
 * <li>설 명 : DelegatingDragEditPartsTracker</li>
 * <li>작성일 : 2009. 12. 8.</li>
 * <li>작성자 : ytchoi</li>
 * </ul>
 */
public class DelegatingDragEditPartsTracker extends SelectionTool implements DragTracker {

    /**
     * The delegating editpart (the selectable)
     */
    private EditPart delegatingEditPart;

    /**
     * The delegate editpart (the dragable)
     */
    private EditPart delegateEditPart;

    /**
     * The initial mouse event upon dragging
     */
    private MouseEvent initialME;

    /**
     * Creates an instance of the delegating drag editparts tracker
     * 
     * @param delegatingEditPart
     *            the <code>EditPart</code> that the selection gets delegated to
     * @param delegateEditPart
     *            the <code>EditPart</code> that the drag gets delegated to.
     */
    public DelegatingDragEditPartsTracker(EditPart delegatingEditPart, EditPart delegateEditPart) {
        this.delegatingEditPart = delegatingEditPart;
        this.delegateEditPart = delegateEditPart;
    }

    /**
     * @see org.eclipse.gef.tools.SelectionTool#handleButtonDown(int)
     */
    protected boolean handleButtonDown(int button) {
        setDragTracker(new SelectEditPartTracker(delegatingEditPart));
        lockTargetEditPart(delegatingEditPart);
        return true;
    }

    /**
     * @see org.eclipse.gef.tools.SelectionTool#mouseDown(org.eclipse.swt.events.MouseEvent,
     *      org.eclipse.gef.EditPartViewer)
     */
    public void mouseDown(MouseEvent e, EditPartViewer viewer) {
        initialME = e;
        super.mouseDown(e, viewer);
    }

    /**
     * @see org.eclipse.gef.tools.AbstractTool#handleDragStarted()
     */
    protected boolean handleDragStarted() {
        DragTracker tracker = delegateEditPart.getDragTracker(getTargetRequest());
        if (tracker != null) {
            setDragTracker(tracker);
            lockTargetEditPart(delegateEditPart);
            tracker.mouseDown(initialME, getCurrentViewer());
        }
        return super.handleDragStarted();
    }

}
