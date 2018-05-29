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
package katyusha.sorceress.datasource.loader;



/**
 * @author DaneBrown on 29/05/2018.
 * Email:tain198127@163.com
 * All Right Reserved
 */
public class DistributedConsistencyPoolLoader extends ClassLoader {
    /**
     *
     * @param name the name of class
     * @param resolve  Links the specified class.  This (misleadingly named) method may be
     * used by a class loader to link a class.  If the class <tt>c</tt> has
     * already been linked, then this method simply returns. Otherwise, the
     * class is linked as described in the "Execution" chapter of
     * <cite>The Java&trade; Language Specification</cite>.
     * @return class object
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class clz = null;
        clz = this.findLoadedClass(name);
        if (clz != null)
            return clz;
        byte[] bs = loadClassFromResource(name);
        if (bs != null && bs.length > 0) {
            clz = this.defineClass(name, bs, 0, bs.length);
        }
        if (clz == null) {
            clz = this.findSystemClass(name);
        }
        if (resolve && clz != null) {
            this.resolveClass(clz);
        }
        return clz;

    }

    /**
     * read byte array from web source
     *
     * @param name
     * @return
     */
    private byte[] loadClassFromResource(String name) {
        return new byte[100];
    }

}
