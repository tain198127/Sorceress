/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package katyusha.sorceress.datasource.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @author Created by DaneBrown on 29/05/2018 Email:tain198127@163.com All Right Reserved
 */
public class DistributeTransactionAspect {
    /**
     * cut the method which descript by DistributeTransactional
     * @param point
     */
    @Around(value="@annotation(katyusha.sorceress.datasource.annotation.DistributeTransactional)")
    public void aroundTransactionMethod(ProceedingJoinPoint point) {
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
