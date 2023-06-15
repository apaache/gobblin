/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.gobblin.runtime.api;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * This is an interface to package all the parameters that should be used to search {@link Spec} in a {@link SpecStore}
 */
public interface SpecSearchObject {

  /** @returns `baseStatement`, further constrained by the search object's restrictions (e.g. through (unbound) `WHERE` clause conditions) */
  String augmentBaseGetStatement(String baseStatement) throws IOException;

  /** Bind all placeholders in `statement`, which must have been prepared from the result of {@link this.augmentBaseGetStatment()} */
  public void completePreparedStatement(PreparedStatement statement) throws SQLException;
}
