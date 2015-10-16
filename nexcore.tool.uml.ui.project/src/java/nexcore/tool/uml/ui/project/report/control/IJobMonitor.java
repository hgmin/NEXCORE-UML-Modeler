/**
 * Copyright (c) 2015 SK Holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK Holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK Holdings.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 */

package nexcore.tool.uml.ui.project.report.control;

/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.uml.ui.project</li>
 * <li>서브 업무명 : nexcore.tool.uml.ui.project.report.control</li>
 * <li>설  명 : IJobMonitor</li>
 * <li>작성일 : 2010. 10. 12.</li>
 * <li>작성자 : 오은주</li>
 * </ul>
 */
public interface IJobMonitor {

    /**
     * setMonitor
     *  
     * @param message void
     */
    void setMonitor(String message);

    /**
     * startTask
     *  
     * @param message
     * @param nTotalCount void
     */
    void startTask(String message, int nTotalCount);

    /**
     * endTask
     *   void
     */
    void endTask();

    /**
     * isCanceled
     *  
     * @return boolean
     */
    boolean isCanceled();
}
