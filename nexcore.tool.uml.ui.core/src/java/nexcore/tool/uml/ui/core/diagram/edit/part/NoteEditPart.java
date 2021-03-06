/**
 * Copyright (c) 2015 SK holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK holdings.
 * (http://www.eclipse.org/legal/epl-v10.html)
 */

package nexcore.tool.uml.ui.core.diagram.edit.part;

import nexcore.tool.uml.core.log.Log;
import nexcore.tool.uml.manager.ManagerConstant;
import nexcore.tool.uml.model.umldiagram.NotationNode;
import nexcore.tool.uml.ui.core.diagram.command.DirectEditCellEditorLocator;
import nexcore.tool.uml.ui.core.diagram.command.DirectEditorManager;
import nexcore.tool.uml.ui.core.diagram.editor.MultilineCellEditor;
import nexcore.tool.uml.ui.core.diagram.figure.NoteFigure;
import nexcore.tool.uml.ui.core.util.PreferenceUtil;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.ui.core</li>
 * <li>서브 업무명 : nexcore.tool.uml.ui.core.diagram.edit.part</li>
 * <li>설  명 : NoteEditPart</li>
 * <li>작성일 : 2009. 11. 12.</li>
 * <li>작성자 : ytchoi</li>
 * </ul>
 */
public class NoteEditPart extends AbstractNotationNodeEditPart {

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    @Override
    protected IFigure createFigure() {

        NotationNode notationNode = (NotationNode) getModel();

        NoteFigure noteFigure = new NoteFigure();
        noteFigure.setSize(notationNode.getWidth(), notationNode.getHeight());
        noteFigure.setLocation(new Point(notationNode.getX(), notationNode.getY()));
        noteFigure.setName(notationNode.getName());

        return noteFigure;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
     */
    @Override
    protected void refreshVisuals() {
        try {
            super.refreshVisuals();
            
            NotationNode notationNode = (NotationNode) getModel();

            Rectangle bounds = new Rectangle(notationNode.getX(),
                notationNode.getY(),
                notationNode.getWidth(),
                notationNode.getHeight());

            ((NoteFigure) getFigure()).setName(notationNode.getName());
            getFigure().setSize(notationNode.getWidth(), notationNode.getHeight());
            getFigure().setLocation(new Point(notationNode.getX(), notationNode.getY()));

            setLayoutConstraint(this, getFigure(), bounds);

            IPreferenceStore store = PreferenceUtil.INSTANCE.getPreferenceStore();
            String fillColorValue = store.getString(ManagerConstant.PREFERENCE_CONSTANT_KEY__NEXCORE_TOOL_UML_COLORSANDFONTS_NOTE_FILL);
            if (fillColorValue.equals("")) {
                ((NoteFigure) getFigure()).setColor(new Color(null, PreferenceUtil.INSTANCE.getNoteFillColor()));
            } else {
                RGB fillColor = PreferenceUtil.INSTANCE.getValueOfColorFieldEditor(ManagerConstant.PREFERENCE_CONSTANT_KEY__NEXCORE_TOOL_UML_COLORSANDFONTS_NOTE_FILL);
                ((NoteFigure) getFigure()).setColor(new Color(null, fillColor));
            }
            @SuppressWarnings("unused")
            String fontColorValue = store.getString(ManagerConstant.PREFERENCE_CONSTANT_KEY__NEXCORE_TOOL_UML_COLORSANDFONTS_NOTE_FONT);
            if (fillColorValue.equals("")) {
                ((NoteFigure) getFigure()).setFontColor(new Color(null, PreferenceUtil.INSTANCE.getNoteFontColor()));
            } else {
                RGB fillColor = PreferenceUtil.INSTANCE.getValueOfColorFieldEditor(ManagerConstant.PREFERENCE_CONSTANT_KEY__NEXCORE_TOOL_UML_COLORSANDFONTS_NOTE_FONT);
                ((NoteFigure) getFigure()).setFontColor(new Color(null, fillColor));
            }

        } catch (Exception e) {
            Log.error("NoteEditPart refreshVisuals() Error " + e);
        }
    }

    /**
     * @see nexcore.tool.uml.ui.core.diagram.edit.part.AbstractNotationNodeEditPart#performRequest(org.eclipse.gef.Request)
     */
    @Override
    public void performRequest(Request req) {
        if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
            setDirectManager(new DirectEditorManager(this,
                MultilineCellEditor.class,
                new DirectEditCellEditorLocator(figure)));
        }
        super.performRequest(req);
    }

}
