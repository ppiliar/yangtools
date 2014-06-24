/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.common;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.opendaylight.yangtools.concepts.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class QNameModule implements Immutable, Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(QNameModule.class);
    private static final long serialVersionUID = 1L;

    //Nullable
    private final URI namespace;

    //Nullable
    private final Date revision;

    //Nullable
    private String formattedRevision;

    private QNameModule(final URI namespace, final Date revision) {
        this.namespace = namespace;
        this.revision = revision;
    }

    public static QNameModule create(final URI namespace, final Date revision) {
        return new QNameModule(namespace, revision);
    }

    public String getFormattedRevision() {
        if (revision == null) {
            return null;
        }

        if (formattedRevision == null) {
            synchronized (this) {
                if (formattedRevision == null) {
                    formattedRevision = SimpleDateFormatUtil.getRevisionFormat().format(revision);
                }
            }
        }

        return formattedRevision;
    }

    public URI getNamespace() {
        return namespace;
    }

    public Date getRevision() {
        return revision;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = (namespace == null) ? 0 : namespace.hashCode();
        result = prime * result + ((revision == null) ? 0 : revision.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QNameModule)) {
            return false;
        }
        final QNameModule other = (QNameModule) obj;
        if (namespace == null) {
            if (other.namespace != null) {
                return false;
            }
        } else if (!namespace.equals(other.namespace)) {
            return false;
        }
        if (revision == null) {
            if (other.revision != null) {
                return false;
            }
        } else if (!revision.equals(other.revision)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a namespace in form defined by section 5.6.4. of {@link https
     * ://tools.ietf.org/html/rfc6020}, if namespace is not correctly defined,
     * the method will return <code>null</code> <br>
     * example "http://example.acme.com/system?revision=2008-04-01"
     *
     * @return namespace in form defined by section 5.6.4. of {@link https
     *         ://tools.ietf.org/html/rfc6020}, if namespace is not correctly
     *         defined, the method will return <code>null</code>
     *
     */
    URI getRevisionNamespace() {

        if (namespace == null) {
            return null;
        }

        String query = "";
        if (revision != null) {
            query = "revision=" + getFormattedRevision();
        }

        URI compositeURI = null;
        try {
            compositeURI = new URI(namespace.getScheme(), namespace.getUserInfo(), namespace.getHost(),
                    namespace.getPort(), namespace.getPath(), query, namespace.getFragment());
        } catch (URISyntaxException e) {
            LOG.error("", e);
        }
        return compositeURI;
    }
}
