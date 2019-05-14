package com.sgcc.epri.dataexchangeplatform.Service;

import java.util.List; /**
 * @author ：wmq
 * @date ：Created in 2019/5/12 14:48
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface ModelManager {
        String getModelType();
        String getScreeningConditions();
        String getModelManagerView(int page, int limit);

        String delectModel(String name);

        String getParticularList(String name, int page,int limit,Integer ft );
}
