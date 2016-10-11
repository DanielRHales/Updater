package com.util;

import com.config.Configuration;
import com.config.Constants;
import com.data.StreamHash;
import com.io.Connector;

/**
 * @author Daniel
 */
public class Identifier {

    private String current = null;
    private String remote = null;

    public Identifier() {
    }

    public String getRemote() {
        return remote;
    }

    public boolean updateRequired() {
        return current == null
                || remote == null
                || !current.equals(remote)
                || !Constants.PROGRAM_FILE.exists();
    }

    public void refresh() {
        current =StreamHash.getStreamHash(Configuration.getFileStream().setInputStream(Connector.getFileInputStream()));
        if (remote == null) {
            remote = StreamHash.getStreamHash(Configuration.getUrlStream().setInputStream(Connector.getUrlInputStream()));
        }
        Configuration.getFileStream().close();
    }

}
