/*
 * Copyright (C) 2017 The ORT Project Authors (see <https://github.com/oss-review-toolkit/ort/blob/main/NOTICE>)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */

package org.ossreviewtoolkit.model.scanresult

import org.ossreviewtoolkit.model.Identifier
import org.ossreviewtoolkit.model.Issue
import org.ossreviewtoolkit.model.KnownProvenance

data class PackageProvenance(
    /**
     * The identifier of the project or package.
     */
    val id: Identifier,

    /**
     * The resolved provenance if provenance resolution was successful.
     */
    val provenance: KnownProvenance?,

    /**
     * The issue happened if provenance resolution was not successful.
     */
    val issue: Issue?
) {
    init {
        require((provenance != null).xor(issue != null)) {
            "Either provenance or issue must be null, but not neither or both."
        }
    }
}
