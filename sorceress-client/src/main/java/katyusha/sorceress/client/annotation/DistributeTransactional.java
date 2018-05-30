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
package katyusha.sorceress.client.annotation;

/**
 * @author Created by DaneBrown on 29/05/2018
 * Email:tain198127@163.com
 * All Right Reserved
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * define a annotation desc a method in distribute transaction
 */
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributeTransactional {
    boolean isAutoRollback() default true;

    boolean isAutoCommit() default true;

    String commitMethod() default "";

    String rollbackMethod() default "";
}