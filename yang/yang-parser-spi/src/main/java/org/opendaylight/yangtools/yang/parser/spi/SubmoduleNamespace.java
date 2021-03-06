/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.parser.spi;

import org.eclipse.jdt.annotation.NonNull;
import org.opendaylight.yangtools.yang.model.api.meta.EffectiveStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.SubmoduleStatement;
import org.opendaylight.yangtools.yang.model.repo.api.SourceIdentifier;
import org.opendaylight.yangtools.yang.parser.spi.meta.NamespaceBehaviour;
import org.opendaylight.yangtools.yang.parser.spi.meta.StatementNamespace;
import org.opendaylight.yangtools.yang.parser.spi.meta.StmtContext;

/**
 * Submodule equivalent of ModuleNamespace.
 */
// FIXME: describe scoping of this namespace
public interface SubmoduleNamespace
    extends StatementNamespace<SourceIdentifier, SubmoduleStatement, EffectiveStatement<String, SubmoduleStatement>> {
    NamespaceBehaviour<SourceIdentifier, StmtContext<?, SubmoduleStatement,
            EffectiveStatement<String, SubmoduleStatement>>, @NonNull SubmoduleNamespace> BEHAVIOUR =
            NamespaceBehaviour.global(SubmoduleNamespace.class);
}
