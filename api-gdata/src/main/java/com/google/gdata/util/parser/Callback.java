/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gdata.util.parser;

/**
 * <code>Callback</code> interface for the <code>Action</code>
 * class. <code>Callback.handle</code> is invoked when the <code>Action</code>
 * parser the <code>Callback</code> is associated with fires.
 *
 * @param <T>
 * @see Action
 * 
 */
public interface Callback<T> {
  /**
   * Called when an <code>Action</code> fires.
   *
   * @param buf The buffer being parsed
   *
   * @param start The start offset of the match.
   *
   * @param end The end offset of the match. If <code>start == end</code>, an
   * empty match occurred.
   *
   * @param udata The user specified object that was passed to
   * <code>Parser.parse</code>.
   */
  public void handle(char[] buf, int start, int end, T udata);
}
