package com.canonicalexamples.tearank.views

import android.os.Build
import android.util.EventLog
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.canonicalexamples.tearank.util.Event
import com.canonicalexamples.tearank.viewmodels.TeaEditViewModel
import com.canonicalexamples.tearank.viewmodels.TeasListViewModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
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
@Config(sdk = [Build.VERSION_CODES.P])
class TeasListFragmentTest {
    @get:Rule
    val rule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)
    private lateinit var sut: FragmentScenario<TeasListFragment>
    @Mock
    private lateinit var viewModel: TeasListViewModel
    @Mock private lateinit var navController: NavController

    @Before
    fun setUp() {
        loadKoinModules(
            module(override = true) {
                factory { viewModel }
                factory { navController }
            }
        )
    }

    @Test
    fun navigationDestinationTriggersNavigation() {
        val destination = MutableLiveData <Event<Boolean>>(Event(false))
        whenever(viewModel.navigateToTeaEdit).thenReturn(destination)
        sut = launchFragmentInContainer()

        destination.value = Event(true)

        argumentCaptor<NavDirections>().apply {
            verify(navController, atLeastOnce()).navigate(capture())
            assertEquals(TeasListFragmentDirections.actionTeasListFragmentToTeaEditFragment(),
                lastValue)
        }
    }
}
