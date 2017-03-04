package com.util;

import com.config.Configuration;
import com.config.Constants;
import com.data.StreamHash;
import com.io.Connector;

/**
 * @author Daniel
 */
public class Identifier {

    private String local = null;
    private String remote = null;

    public Identifier() {
    }

    public String getRemote() {
        return remote;
    }

    public boolean updateRequired() {
        return local == null || remote == null || !local.equals(remote) || !Constants.PROGRAM_FILE.exists();
    }

    public void refresh() {
        local = StreamHash.getStreamHash(Configuration.getFileStream().setInputStream(Connector.getFileInputStream()));
        if (remote == null) {
            remote = StreamHash.getStreamHash(Configuration.getUrlStream().setInputStream(Connector.getUrlInputStream()));
        }
        Configuration.getFileStream().close();
    }

}
