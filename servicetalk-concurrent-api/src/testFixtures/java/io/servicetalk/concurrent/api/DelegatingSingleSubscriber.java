/*
 * Copyright © 2019 Apple Inc. and the ServiceTalk project authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.servicetalk.concurrent.api;

import io.servicetalk.concurrent.Cancellable;
import io.servicetalk.concurrent.SingleSource.Subscriber;

import static java.util.Objects.requireNonNull;

class DelegatingSingleSubscriber<T> implements Subscriber<T> {

    private final Subscriber<? super T> delegate;

    DelegatingSingleSubscriber(final Subscriber<? super T> delegate) {
        this.delegate = requireNonNull(delegate);
    }

    @Override
    public void onSubscribe(final Cancellable s) {
        delegate.onSubscribe(s);
    }

    @Override
    public void onSuccess(final T result) {
        delegate.onSuccess(result);
    }

    @Override
    public void onError(final Throwable t) {
        delegate.onError(t);
    }
}
