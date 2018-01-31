/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.services.process.model.core.version;

import java.util.Optional;

import org.springframework.stereotype.Component;

/**
 * Version generator.
 *
 * TODO: To set VersionGenerationStrategy from application properties, if any.
 */
@Component
public class VersionGenerator {

    private VersionGenerationStrategy versionGenerationStrategy = IncrementPatchVersionGenerationStrategy.INSTANCE;

    /**
     * Generate the next version relative to the given latest version.
     *
     * @param latestVersion the latest version
     * @return the next version
     */
    public String generateNextVersion(Optional<VersionEntity> latestVersion) {
        return versionGenerationStrategy.generateNextVersion(
                latestVersion.map(VersionEntity::getVersion));
    }
}
