package com.canonicalexamples.tearank.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.canonicalexamples.tearank.R
import com.canonicalexamples.tearank.viewmodels.TeaEditViewModel
import kotlinx.android.synthetic.main.fragment_tea_edit.*
import org.koin.android.viewmodel.ext.android.viewModel as viewModelDelegate

/**
 * 20190623. Initial version created by jorge
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
class TeaEditFragment : Fragment() {

    private val viewModel: TeaEditViewModel by viewModelDelegate()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_tea_edit, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_button.isEnabled = viewModel.saveButtonEnabled
        save_button.setOnClickListener {
            viewModel.saveButtonTapped()
        }
    }
}
