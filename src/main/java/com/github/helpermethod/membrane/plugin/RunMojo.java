package com.github.helpermethod.membrane.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "run")
public class RunMojo extends AbstractMojo {
    @Parameter(property = "membrane.proxiesPath", defaultValue = "src/it/proxies.xml")
    private String proxiesPath;

    public void execute() throws MojoExecutionException, MojoFailureException {
        RouterFacade.createStarted(proxiesPath).waitForFinish();
    }
}