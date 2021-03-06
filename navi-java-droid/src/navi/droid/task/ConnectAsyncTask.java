package navi.droid.task;

import navi.common.connector.client.ClientListener;
import navi.droid.NaviDroidHandler;
import navi.droid.NaviDroidMain;

import java.io.IOException;

public class ConnectAsyncTask extends NaviAsyncTask<Object> {

    public ConnectAsyncTask(NaviDroidMain main) {
        super(main);
    }

    @Override
    protected Void doInBackground(Object... args) {
        final String hostname = (String) args[0];
        final int port = Integer.parseInt((String) args[1]);
        final ClientListener listener = (ClientListener) args[2];

        try {
            NaviDroidHandler.getNetwork().connect(hostname, port, listener);
            getMain().connected(hostname, port);
        } catch (IOException e) {
            getMain().notConnected(hostname, port);
        }
        return null;
    }
}
