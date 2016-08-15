package com.util;

import com.config.Configuration;
import com.config.Constants;
import com.data.CheckSum;
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
        current = CheckSum.getStreamHash(Configuration.getFileStream().setInputStream(Connector.getFileInputStream()));
        if (remote == null) {
            remote = CheckSum.getStreamHash(Configuration.getUrlStream().setInputStream(Connector.getUrlInputStream()));
        }
    }
}
