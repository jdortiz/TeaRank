package com.canonicalexamples.tearank.views

import android.os.Build
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.canonicalexamples.tearank.R
import com.canonicalexamples.tearank.viewmodels.TeaEditViewModel
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.android.synthetic.main.fragment_tea_edit.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness
import org.robolectric.annotation.Config

/**
 * 20191024. Initial version created by jorge
 * for a Canonical Examples training.
 *
 *
 * Copyright 2019 Jorge D. Ortiz Fuentes
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@RunWith(AndroidJUnit4::class)
@Config(sdk=[Build.VERSION_CODES.P])
class TeaEditFragmentTest: AutoCloseKoinTest() {
    @get:Rule
    val rule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)
    private lateinit var sut: FragmentScenario<TeaEditFragment>
    @Mock private lateinit var viewModel: TeaEditViewModel

    @Before
    fun setUp() {
        loadKoinModules(
            module(override = true) {
                factory { viewModel }
            }
        )
    }

    @Test(expected = Test.None::class)
    fun startsWithoutCrashing() {
        sut = launchFragmentInContainer()
    }

    @Test
    fun saveButtonSendsEventToViewModel() {
        whenever(viewModel.saveButtonEnabled).thenReturn(true)
        sut = launchFragmentInContainer()

        onView(withId(R.id.save_button)).perform(click())

        verify(viewModel).saveButtonTapped()
    }

    @Test
    fun saveButtonStartsEnabled() {
        whenever(viewModel.saveButtonEnabled).thenReturn(true)

        sut = launchFragmentInContainer()

        onView(withId(R.id.save_button)).check(matches(isEnabled()))

    }
}
