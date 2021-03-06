/**
 * Copyright (c) 2015 SK holdings Co., Ltd. All rights reserved.
 * This software is the confidential and proprietary information of SK holdings.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of the license agreement you entered into with SK holdings.
 * (http://www.eclipse.org/legal/epl-v10.html)
 */

package nexcore.tool.mdd.core.registry.container;

import nexcore.tool.mdd.core.extension.IDomainModelHandler;

/**
 * <ul>
 * <li>업무 그룹명 : nexcore.tool.mdd.core</li>
 * <li>서브 업무명 : nexcore.tool.mdd.core.registry.container</li>
 * <li>설 명 : IDomainModelHandlerContainer</li>
 * <li>작성일 : 2010. 11. 19.</li>
 * <li>작성자 : 최윤석</li>
 * </ul>
 */
public interface IDomainModelHandlerContainer {

    /**
     * 아이디 설정
     * 
     * @param id
     *            void
     */
    public void setId(String id);

    /**
     * 아이디 반환
     * 
     * @return String
     */
    public String getId();

    /**
     * 라벨 설정
     * 
     * @param label
     *            void
     */
    public void setLabel(String label);

    /**
     * 라벨 반환
     * 
     * @return String
     */
    public String getLabel();

    /**
     * 도메인 모델 핸들러 설정
     * 
     * @param domainModelHandler
     *            void
     */
    public void setModelHandler(IDomainModelHandler domainModelHandler);

    /**
     * 도메인 모델 핸들러 반환
     * 
     * @return INotationModelHandler
     */
    public IDomainModelHandler getModelHandler();

}
