/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import org.apache.commons.lang.StringUtils;
import org.mule.modules.google.api.proxy.ProxyOptions;

public class CommonsUtils
{
    public static Proxy createProxy(final ProxyOptions proxyOptions)
    {
        if(proxyOptions == null || StringUtils.isEmpty(proxyOptions.getHost())) {
            return null;
        }

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyOptions.getHost(), proxyOptions.getPort()));

        if (StringUtils.isNotEmpty(proxyOptions.getUser())) {
            Authenticator.setDefault(new Authenticator()
            {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(proxyOptions.getUser(), proxyOptions.getPassword().toCharArray());
                }

            });
        }

        return proxy;
    }
}