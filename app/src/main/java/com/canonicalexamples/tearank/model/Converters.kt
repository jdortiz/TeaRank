package com.canonicalexamples.tearank.model

import androidx.room.TypeConverter
import java.util.Date

/**
 * 20191022. Initial version created by jorge
 * for a Canonical Examples training.
 *
 * Copyright 2019 Jorge D. Ortiz Fuentes
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
class Converters {
    @TypeConverter
    fun timestampToDate(value: Long?): Date? = if (value == null) { null } else { Date(value) }
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time
}
