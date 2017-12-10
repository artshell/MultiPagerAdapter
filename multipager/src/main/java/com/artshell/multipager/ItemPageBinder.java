/*
 * Copyright 2017 artshell. https://github.com/artshell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.artshell.multipager;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artshell.multipager.MultiPagerAdapter.PageHolder;

/**
 * @author artshell on 28/10/2017
 */

public abstract class ItemPageBinder<T, VH extends PageHolder> {

    protected abstract VH onCreateViewHolder(LayoutInflater inflater, ViewGroup container, int position);

    protected abstract void onBindViewHolder(@NonNull VH holder, @NonNull T item);

}
