package com.config;

import com.io.Stream;
import com.logging.Logger;
import com.util.Identifier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

/**
 * @author Daniel
 */
public final class Configuration {

    private static final MessageDigest digest = getMessageDigest();

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

    public static MessageDigest getDigest() {
        return digest;
    }

    private static MessageDigest getMessageDigest() {
        try {
            return getMessageDigest(Constants.ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Logger.log(Configuration.class, Level.SEVERE, String.format("No Such Algorithm - %s", Constants.ALGORITHM), ex);
            return null;
        }
    }

    private static MessageDigest getMessageDigest(String algorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }
}
