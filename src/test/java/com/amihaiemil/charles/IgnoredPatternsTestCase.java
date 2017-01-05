/**
 * Copyright (c) 2016-2017, Mihai Emil Andronache
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * * Neither the name of charles nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.amihaiemil.charles;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test cases for {@link IgnoredPatterns}
 * @author Mihai Andronache (amihaiemil@gmail.com)
 *
 */
public class IgnoredPatternsTestCase {
    /**
     * IgnoredPatterns can recognize a url that should be ignored.
     */
    @Test
    public void containsPattern() {
        IgnoredPatterns patterns = new IgnoredPatterns(
                                            Arrays.asList(
                                                "www.test.com/*.js",
                                                "www.test.com/conf/* ",
                                                "www.test.com/*/test/page*.html",
                                                "www\\.test\\.com/[a-zA-z]+/hello\\.html",
                                                "*.css"
                                            )
                                   );
        assertTrue(patterns.contains("www.test.com/js/hello.js"));
        assertTrue(patterns.contains("www.test.com/hello.js"));
        assertTrue(patterns.contains("www.test.com/p/test/page.html"));
        assertTrue(patterns.contains("www.test.com/test/page.html"));
        assertTrue(patterns.contains("www.test.com/test/pageTest.html"));
        
        assertTrue(patterns.contains("www.test.com/conf/configpage.html"));
        assertTrue(patterns.contains("www.test.com/hitest/hello.html"));
        assertTrue(patterns.contains("www.test.com/css/main.css"));
        
        assertFalse(patterns.contains("www.test.com/test/test.html"));
        assertFalse(patterns.contains("www.test.com/p/page.html"));

    }
}
