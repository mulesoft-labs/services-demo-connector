/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.jartry;

import org.mule.modules.tests.ConnectorTestCase;
import org.mule.tck.junit4.FunctionalTestCase;
import org.junit.Test;

public class JarTryConnectorTest extends FunctionalTestCase {
    
    @Override
    protected String getConfigResources() {
        return "jar-try-config.xml";
    }

    @Test
    public void testFlow() throws Exception {
        runFlowAndExpect("testFlow", "Another string");
    }
}
