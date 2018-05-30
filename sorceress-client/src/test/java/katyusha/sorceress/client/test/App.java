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
package katyusha.sorceress.client.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Created by DaneBrown on 30/05/2018. Email:tain198127@163.com . All Right Reserved
 */
@ContextConfiguration(locations = {"classpath:/springContext-test.xml"})
@EnableAutoConfiguration
@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(App.class);
        ApplicationContext ctx =  app.run(args);

//        ctx.getBean(AopImpl.class).aoptest();

    }
    @RequestMapping("/health")
    public String testHealth(){
        return "ok";
    }
}
