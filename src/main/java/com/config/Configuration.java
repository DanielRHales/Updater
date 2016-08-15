package com.config;

import com.io.Stream;
import com.util.Identifier;

/**
 * @author Daniel
 */
public final class Configuration {

    private static final Stream fileStream = new Stream();

    private static final Stream urlStream = new Stream();

    private static final Identifier IDENTIFIER = new Identifier();

    public static Identifier getIdentifier() {
        return IDENTIFIER;
    }

    public static Stream getFileStream() {
        return fileStream;
    }

    public static Stream getUrlStream() {
        return urlStream;
    }
}
