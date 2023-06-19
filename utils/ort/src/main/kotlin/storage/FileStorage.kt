/*
 * Copyright (C) 2019 The ORT Project Authors (see <https://github.com/oss-review-toolkit/ort/blob/main/NOTICE>)
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

package org.ossreviewtoolkit.utils.ort.storage

import java.io.InputStream

/**
 * A generic storage interface that associates a key of type [T] with an [InputStream].
 */
interface FileStorage<T> {
    /**
     * Return whether any data is associated by [key].
     */
    fun exists(key: T): Boolean

    /**
     * Return the data associated by [key], or null if there is no such data. It is the caller's responsibility to close
     * the [InputStream].
     */
    fun read(key: T): InputStream

    /**
     * Associate [key] with the given [inputStream]. Any existing association by [key] is replaced. The function
     * implementation is responsible for closing the [InputStream].
     */
    fun write(key: T, inputStream: InputStream)
}
