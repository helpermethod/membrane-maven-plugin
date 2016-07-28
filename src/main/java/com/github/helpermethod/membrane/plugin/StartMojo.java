package com.github.helpermethod.membrane.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "start", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST)
public class StartMojo extends AbstractMojo {
    @Parameter(property = "membrane.proxiesPath", defaultValue = "src/test/resources/proxies.xml")
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