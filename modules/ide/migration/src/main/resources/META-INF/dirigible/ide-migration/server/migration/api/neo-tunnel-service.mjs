/*
 * Copyright (c) 2022 codbex or an codbex affiliate company and contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 codbex or an codbex affiliate company and contributors
 * SPDX-License-Identifier: EPL-2.0
 */
import { configurations as config } from "@dirigible/core";
import { MigrationToolExecutor } from "./migration-tool-executor.mjs";

const neoClientPath = config.get("user.dir") + "/target/dirigible/resources-neo-sdk/sdk/tools/neo.sh";

export class NeoTunnelService {
    constructor() {
        this.migrationToolExecutor = new MigrationToolExecutor();
    }

    openTunnel(account, host, jwtToken, databaseId) {
        const script = `${neoClientPath} open-db-tunnel -a "${account}" -h "${host}" -u JWT -p "${jwtToken}" -i "${databaseId}" --output json --background`;

        const rawCommandResult = this.migrationToolExecutor.execute(script);

        const commandResult = JSON.parse(rawCommandResult);
        if (commandResult.errorMsg) {
            throw "[NEO CLIENT ERROR]" + commandResult.errorMsg;
        }

        return commandResult.result;
    }

    closeTunnel(sessionId) {
        const script = `${neoClientPath} close-db-tunnel --session-id ${sessionId}`;
        this.migrationToolExecutor.execute(script);
    }
}
