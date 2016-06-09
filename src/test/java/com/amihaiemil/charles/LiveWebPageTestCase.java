/*
 Copyright (c) 2016, Mihai Emil Andronache
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.
 * Neither the name of charles nor the names of its
 contributors may be used to endorse or promote products derived from
 this software without specific prior written permission.
 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.amihaiemil.charles;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;
import org.mockito.Mockito;

import com.amihaiemil.charles.sitemap.Url;

/**
 * Unit tests for {@link LiveWebPage}
 * @author Mihai Andronache (amihaiemil@gmail.com)
 *
 */
public class LiveWebPageTestCase {

	/**
	 * {@link LiveWebPage} can return a snapshot of itself.
	 */
	@Test
	public void returnsSnapshot() {
		LiveWebPage livePage = Mockito.mock(LiveWebPage.class);
		Mockito.when(livePage.snapshot()).thenCallRealMethod();
		Mockito.when(livePage.getTitle()).thenReturn("Test title");
		Mockito.when(livePage.getTextContent()).thenReturn("content...");
		Mockito.when(livePage.getUrl()).thenReturn(new Url("test.com"));
		Mockito.when(livePage.getLinks()).thenReturn(new HashSet<Link>());
		
		WebPage snapshotPage = livePage.snapshot();
		assertTrue(snapshotPage.getTitle().equals("Test title"));
		assertTrue(snapshotPage.getTextContent().equals("content..."));
		assertTrue(snapshotPage.getUrl().equals(new Url("test.com")));
		assertTrue(snapshotPage.getLinks().isEmpty());
	}
}