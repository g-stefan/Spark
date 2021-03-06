/**
 * Copyright (C) 2004-2011 Jive Software. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.sparkimpl.plugin.alerts;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * XEP-0224 Compliance<br>
 * see <a
 * href="http://xmpp.org/extensions/xep-0224.html">http://xmpp.org/extensions/xep-0224.html</a>
 */
public class BuzzPacket implements ExtensionElement
{
    public static final String ELEMENT_NAME = "attention";

    public static final String NAMESPACE = "urn:xmpp:attention:0";

    @Override
	public String getElementName() {
	return ELEMENT_NAME;
    }

    @Override
	public String getNamespace() {
	return NAMESPACE;
    }

    // TODO 2.7.0 remove buzz only attention gets to stay
    @Override
	public String toXML(String enclosingNamespace) {
	return "<" + getElementName() + " xmlns=\"" + getNamespace()
		+ "\"/><buzz xmlns=\"http://www.jivesoftware.com/spark\"/>";
    }

    public static class Provider extends ExtensionElementProvider<BuzzPacket> {

        public Provider() {
        }

        @Override
        public BuzzPacket parse( XmlPullParser parser, int i ) throws XmlPullParserException, IOException, SmackException
        {
            return new BuzzPacket();
        }
    }
}
