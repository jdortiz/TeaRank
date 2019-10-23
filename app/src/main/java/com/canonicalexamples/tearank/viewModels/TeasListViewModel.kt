package com.canonicalexamples.tearank.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canonicalexamples.tearank.util.Event

/**
 * 20190624. Initial version created by jorge
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
class TeasListViewModel: ViewModel() {
    //<editor-fold desc="Properties">
    private val _navigateToTeaEdit = MutableLiveData<Event<Boolean>>()
    val navigateToTeaEdit: LiveData<Event<Boolean>> = _navigateToTeaEdit
    //</editor-fold>

    //<editor-fold desc="Events from UI">
    fun addButtonClicked() {
        _navigateToTeaEdit.value = Event(content = true)
    }
    //</editor-fold>
}
