/**
 * Copyright (c) 2015 SK holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK holdings.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 */
package nexcore.tool.uml.ui.project.explorer.provider;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import nexcore.tool.uml.ui.core.util.ProjectUtil;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.BuildAction;
import org.eclipse.ui.actions.CloseResourceAction;
import org.eclipse.ui.actions.CloseUnrelatedProjectsAction;
import org.eclipse.ui.actions.OpenResourceAction;
import org.eclipse.ui.actions.RefreshAction;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.StatusUtil;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

/**
 * 사용하는 곳이 없음.
 * @since 3.2
 * 
 */
/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.ui.project</li>
 * <li>서브 업무명 : nexcore.tool.uml.ui.project.explorer.provider</li>
 * <li>설  명 : UMLResourceMgmtActionProvider</li>
 * <li>작성일 : 2015. 10. 6.</li>
 * <li>작성자 : 탁희수 </li>
 * </ul>
 */
@Deprecated
public class UMLResourceMgmtActionProvider extends CommonActionProvider {

    /**
     * buildAction
     */
    private BuildAction buildAction;

    /**
     * openProjectAction
     */
    private OpenResourceAction openProjectAction;

    /**
     * closeProjectAction
     */
    private CloseResourceAction closeProjectAction;

    /**
     * closeUnrelatedProjectsAction
     */
    private CloseUnrelatedProjectsAction closeUnrelatedProjectsAction;

    /**
     * refreshAction
     */
    private RefreshAction refreshAction;

    /**
     * shell
     */
    private Shell shell;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator
     * .ICommonActionExtensionSite)
     */
    /**
     * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
     */
    public void init(ICommonActionExtensionSite aSite) {
        super.init(aSite);
        shell = aSite.getViewSite().getShell();
        makeActions();
    }

    /**
     * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
     */
    public void fillActionBars(IActionBars actionBars) {
        actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), refreshAction);
        actionBars.setGlobalActionHandler(IDEActionFactory.BUILD_PROJECT.getId(), buildAction);
        actionBars.setGlobalActionHandler(IDEActionFactory.OPEN_PROJECT.getId(), openProjectAction);
        actionBars.setGlobalActionHandler(IDEActionFactory.CLOSE_PROJECT.getId(), closeProjectAction);
        actionBars.setGlobalActionHandler(IDEActionFactory.CLOSE_UNRELATED_PROJECTS.getId(),
            closeUnrelatedProjectsAction);
        updateActionBars();
    }

    /**
     * Adds the build, open project, close project and refresh resource actions
     * to the context menu.
     * <p>
     * The following conditions apply: build-only projects selected, auto build
     * disabled, at least one builder present open project-only projects
     * selected, at least one closed project close project-only projects
     * selected, at least one open project refresh-no closed project selected
     * </p>
     * <p>
     * Both the open project and close project action may be on the menu at the
     * same time.
     * </p>
     * <p>
     * No disabled action should be on the context menu.
     * </p>
     * 
     * @param menu
     *            context menu to add actions to
     */
    public void fillContextMenu(IMenuManager menu) {
        IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
        boolean isProjectSelection = true;
        boolean hasOpenProjects = false;
        boolean hasClosedProjects = false;
        boolean hasBuilder = true; // false if any project is closed or does not
        // have builder
        Iterator resources = selection.iterator();

        while (resources.hasNext() && (!hasOpenProjects || !hasClosedProjects || hasBuilder || isProjectSelection)) {
            Object next = resources.next();
            IProject project = null;

            if (next instanceof IProject) {
                project = (IProject) next;
            } else if (next instanceof IAdaptable) {
                project = (IProject) ((IAdaptable) next).getAdapter(IProject.class);
            }

            if (project == null) {
                isProjectSelection = false;
                continue;
            }
            if (project.isOpen()) {
                hasOpenProjects = true;
                if (hasBuilder && !hasBuilder(project)) {
                    hasBuilder = false;
                }
            } else {
                hasClosedProjects = true;
                hasBuilder = false;
            }
        }
        if (!selection.isEmpty() && isProjectSelection && !ResourcesPlugin.getWorkspace().isAutoBuilding()
            && hasBuilder) {
            // Allow manual incremental build only if auto build is off.
            buildAction.selectionChanged(selection);
            menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, buildAction);
        }
        if (!hasClosedProjects) {
            refreshAction.selectionChanged(selection);
            menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, refreshAction);
        }
        if (isProjectSelection) {
            if (hasClosedProjects) {
                openProjectAction.selectionChanged(selection);
                menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, openProjectAction);
            }
            if (hasOpenProjects) {
                closeProjectAction.selectionChanged(selection);
                menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, closeProjectAction);
                closeUnrelatedProjectsAction.selectionChanged(selection);
                menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, closeUnrelatedProjectsAction);
            }
        }
    }

    /**
     * Returns whether there are builders configured on the given project.
     * 
     * @return <code>true</code> if it has builders, <code>false</code> if not,
     *         or if this could not be determined
     */
    boolean hasBuilder(IProject project) {
        try {
            ICommand[] commands = project.getDescription().getBuildSpec();
            if (commands.length > 0) {
                return true;
            }
        } catch (CoreException e) {
            // Cannot determine if project has builders. Project is closed
            // or does not exist. Fall through to return false.
        }
        return false;
    }

    /**
     * makeActions
     *   void
     */
    protected void makeActions() {
        // Shell shell = navigator.getSite().getShell();
        openProjectAction = new OpenResourceAction(shell);

        closeProjectAction = new CloseResourceAction(shell);

        closeUnrelatedProjectsAction = new CloseUnrelatedProjectsAction(shell);

        refreshAction = new RefreshAction(shell) {
            public void run() {
                final IStatus[] errorStatus = new IStatus[1];
                errorStatus[0] = Status.OK_STATUS;
                final WorkspaceModifyOperation op = (WorkspaceModifyOperation) createOperation(errorStatus);
                WorkspaceJob job = new WorkspaceJob("refresh") { //$NON-NLS-1$

                    public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                        try {
                            op.run(monitor);
                            if (shell != null && !shell.isDisposed()) {
                                shell.getDisplay().asyncExec(new Runnable() {
                                    public void run() {
                                        // StructuredViewer viewer =
                                        // getActionSite().getStructuredViewer();
                                        // if (viewer != null
                                        // && viewer.getControl() != null
                                        // && !viewer.getControl()
                                        // .isDisposed()) {
                                        // viewer.refresh();
                                        // }
                                        ProjectUtil.refreshExplorer();
                                    }
                                });
                            }
                        } catch (InvocationTargetException e) {
                            String msg = NLS.bind(IDEWorkbenchMessages.WorkspaceAction_logTitle,
                                getClass().getName(),
                                e.getTargetException());
                            throw new CoreException(StatusUtil.newStatus(IStatus.ERROR, msg, e.getTargetException()));
                        } catch (InterruptedException e) {
                            return Status.CANCEL_STATUS;
                        }
                        return errorStatus[0];
                    }

                };
                ISchedulingRule rule = op.getRule();
                if (rule != null) {
                    job.setRule(rule);
                }
                job.setUser(true);
                job.schedule();
            }
        };
        refreshAction.setDisabledImageDescriptor(getImageDescriptor("dlcl16/refresh_nav.gif"));//$NON-NLS-1$
        refreshAction.setImageDescriptor(getImageDescriptor("elcl16/refresh_nav.gif"));//$NON-NLS-1$       
        refreshAction.setActionDefinitionId("org.eclipse.ui.file.refresh"); //$NON-NLS-1$

        buildAction = new BuildAction(shell, IncrementalProjectBuilder.INCREMENTAL_BUILD);
        buildAction.setActionDefinitionId("org.eclipse.ui.project.buildProject"); //$NON-NLS-1$
    }

    /**
     * Returns the image descriptor with the given relative path.
     */
    protected ImageDescriptor getImageDescriptor(String relativePath) {
        return IDEWorkbenchPlugin.getIDEImageDescriptor(relativePath);

    }

    /**
     * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
     */
    public void updateActionBars() {
        IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
        refreshAction.selectionChanged(selection);
        buildAction.selectionChanged(selection);
        openProjectAction.selectionChanged(selection);
        closeUnrelatedProjectsAction.selectionChanged(selection);
        closeProjectAction.selectionChanged(selection);
    }

}
