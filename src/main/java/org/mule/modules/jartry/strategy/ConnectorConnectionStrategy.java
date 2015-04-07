/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.jartry.strategy;

import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;

/**
 * Connection Management Strategy
 *
 * @author MuleSoft, Inc.
 */
@ConnectionManagement(configElementName = "config", friendlyName = "Connection Managament type strategy")
public class ConnectorConnectionStrategy {
	
    /**
     * Configurable
     */
    @Configurable
    @Default("value")
    private String myStrategyProperty;

    private boolean connected = false;
    
    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String username, @Password String password)
        throws ConnectionException {
    	
    	if (!org.mule.UtilsForTest.testAppender("connect").equals("testconnect")){
    		throw new ConnectionException(ConnectionExceptionCode.CANNOT_REACH, "Failed to use utils", "Failed to use utils");
    	}
    	
    	connected = true;
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
    	connected = false;
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return connected;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }

    /**
     * Set strategy property
     *
     * @param myStrategyProperty my strategy property
     */
    public void setMyStrategyProperty(String myStrategyProperty) {
        this.myStrategyProperty = myStrategyProperty;
    }

    /**
     * Get property
     */
    public String getMyStrategyProperty() {
        return this.myStrategyProperty;
    }
}