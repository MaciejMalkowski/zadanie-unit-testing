package pl.devfoundry. testing;

import org.junit.jupiter.api.extension. ExtensionContext;
import org. junit. jupiter.api.extension. TestExecutionExceptionHandler;

import java.io.IOException;
import java. util. logging.Logger;
public class IAExceptionIgnoreExtension implements TestExecutionExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(IAExceptionIgnoreExtension.class
            .getName());

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {

        if (throwable instanceof IllegalArgumentException || throwable instanceof IOException) {
            LOGGER.info("Ignored exception: " + throwable.getClass().getSimpleName());
            return;
        }

        throw throwable;
    }
}