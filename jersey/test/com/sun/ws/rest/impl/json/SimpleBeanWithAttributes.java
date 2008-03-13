/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved. 
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License").  You may not use this file
 * except in compliance with the License. 
 * 
 * You can obtain a copy of the License at:
 *     https://jersey.dev.java.net/license.txt
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * When distributing the Covered Code, include this CDDL Header Notice in each
 * file and include the License file at:
 *     https://jersey.dev.java.net/license.txt
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 *     "Portions Copyrighted [year] [name of copyright owner]"
 */
package com.sun.ws.rest.impl.json;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author japod
 */
@XmlRootElement
public class SimpleBeanWithAttributes {

    @XmlAttribute public URI uri;
    public String s1;
    @XmlAttribute public int i;
    @XmlAttribute public String j;

    public SimpleBeanWithAttributes() {
    }

    public static Object createTestInstance() {
        SimpleBeanWithAttributes instance = new SimpleBeanWithAttributes();
        instance.s1 = "hi there";
        instance.i = 312;
        instance.j = "bumper";
        try {
            instance.uri = new URI("http://localhost:8080/jedna/bedna/");

        } catch (URISyntaxException ex) {
            Logger.getLogger(SimpleBeanWithAttributes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleBeanWithAttributes other = (SimpleBeanWithAttributes) obj;
        if (this.s1 != other.s1 && (this.s1 == null || !this.s1.equals(other.s1))) {
            return false;
        }
        if (this.j != other.j && (this.j == null || !this.j.equals(other.j))) {
            return false;
        }
        if (this.uri != other.uri && (this.uri == null || !this.uri.equals(other.uri))) {
            return false;
        }
        if (this.i != other.i) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        if (null != s1) {
            hash += 17 * s1.hashCode();
        }
        if (null != j) {
            hash += 17 * j.hashCode();
        }
        if (null != uri) {
            hash += 17 * uri.hashCode();
        }
        hash += 13 * i;
        return hash;
    }

    @Override
    public String toString() {
        return (new Formatter()).format("SBWA(%s,%d,%s,%s)", s1, i, j, uri).toString();
    }
}
