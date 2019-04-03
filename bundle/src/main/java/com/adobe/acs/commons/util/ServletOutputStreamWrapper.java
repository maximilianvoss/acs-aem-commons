/*
 * #%L
 * ACS AEM Commons Bundle
 * %%
 * Copyright (C) 2019 Adobe
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.adobe.acs.commons.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * A {@link ServletOutputStream} based on a simple {@link OutputStream}. 
 * Always returns {@code true} for {@link #isReady()}.
 *
 */
public final class ServletOutputStreamWrapper extends ServletOutputStream {

    private final OutputStream wrappedStream;

    public ServletOutputStreamWrapper(OutputStream wrappedStream) {
        this.wrappedStream = wrappedStream;
    }
    
    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        wrappedStream.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        wrappedStream.write(b);
    }

}
