/*
 * Copyright 2016 Oliver Weiler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.helpermethod.membrane.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "start", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST)
public class StartMojo extends AbstractMojo {
    @Parameter(property = "membrane.proxiesPath", defaultValue = "src/main/resources/proxies.xml")
    private String proxiesPath;
    @Parameter(property = "membrane.skip", defaultValue = "false")
    private boolean skip;

    public void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            return;
        }

        getPluginContext().put("router", RouterFacade.createStarted(proxiesPath));
    }
}
