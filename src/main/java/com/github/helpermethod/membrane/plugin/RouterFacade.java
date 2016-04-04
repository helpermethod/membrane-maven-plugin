package com.github.helpermethod.membrane.plugin;

import com.predic8.membrane.core.Router;
import org.apache.maven.plugin.MojoFailureException;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class RouterFacade {
    private final Router router;

    private RouterFacade(Router router) {
        this.router = router;
    }

    public static RouterFacade createStarted(String proxiesPath) throws MojoFailureException {
        try {
            return new RouterFacade(Router.init(proxiesPath));
        } catch (MalformedURLException e) {
            throw new MojoFailureException("Failure", e);
        }
    }

    public void stop() {
        router.stop();
    }

    public void waitForFinish() {
        try {
            router.getBackgroundInitializator().awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}