/*
 * Copyright (c) 2017 Pantheon Technologies, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.parser.rfc7950.stmt.grouping;

import org.opendaylight.yangtools.yang.model.api.YangStmtMapping;
import org.opendaylight.yangtools.yang.parser.spi.meta.SubstatementValidator;

public final class GroupingStatementRFC6020Support extends AbstractGroupingStatementSupport {
    private static final SubstatementValidator SUBSTATEMENT_VALIDATOR = SubstatementValidator.builder(YangStmtMapping
        .GROUPING)
        .addAny(YangStmtMapping.ANYXML)
        .addAny(YangStmtMapping.CHOICE)
        .addAny(YangStmtMapping.CONTAINER)
        .addOptional(YangStmtMapping.DESCRIPTION)
        .addAny(YangStmtMapping.GROUPING)
        .addAny(YangStmtMapping.LEAF)
        .addAny(YangStmtMapping.LEAF_LIST)
        .addAny(YangStmtMapping.LIST)
        .addOptional(YangStmtMapping.REFERENCE)
        .addOptional(YangStmtMapping.STATUS)
        .addAny(YangStmtMapping.TYPEDEF)
        .addAny(YangStmtMapping.USES)
        .build();
    private static final GroupingStatementRFC6020Support INSTANCE = new GroupingStatementRFC6020Support();

    private GroupingStatementRFC6020Support() {
        // Hidden
    }

    public static GroupingStatementRFC6020Support getInstance() {
        return INSTANCE;
    }

    @Override
    protected SubstatementValidator getSubstatementValidator() {
        return SUBSTATEMENT_VALIDATOR;
    }
}