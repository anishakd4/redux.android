/*
 * Copyright 2019 anishdubey
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
 */

package com.anishdubey.reduxandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.anishdubey.redux.android.ReduxViewModel

/**
 * @author anishdubey
 */
abstract class BaseActivity<T : ReduxViewModel> : AppCompatActivity() {

    lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        viewModel = provideViewModel()
        onCreateView()
    }

    override fun onStart() {
        super.onStart()
        onAttachObservers()
    }

    abstract fun getLayout(): Int

    abstract fun provideViewModel(): T

    abstract fun onCreateView()

    abstract fun onAttachObservers()
}
