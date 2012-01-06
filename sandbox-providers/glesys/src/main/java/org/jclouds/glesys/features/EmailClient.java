/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.glesys.features;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jclouds.concurrent.Timeout;
import org.jclouds.glesys.domain.Email;
import org.jclouds.glesys.domain.EmailOverview;
import org.jclouds.glesys.options.EmailCreateOptions;
import org.jclouds.glesys.options.EmailEditOptions;

/**
 * Provides synchronous access to E-Mail requests.
 * <p/>
 *
 * @author Adam Lowe
 * @see org.jclouds.glesys.features.DomainAsyncClient
 * @see <a href="https://customer.glesys.com/api.php" />
 */
@Timeout(duration = 30, timeUnit = TimeUnit.SECONDS)
public interface EmailClient {

   /**
    * Get a summary of e-mail accounts associated with this Glesys account
    *
    * @return the relevant summary data
    */
   EmailOverview getEmailOverview();

   /**
    * 
    * @return
    */
   Set<Email> listAccounts(String domain);

   void createAccount(String accountAddress, String password, EmailCreateOptions... options);

   void createAlias(String aliasAddress, String toEmailAddress);

   void editAccount(String accountAddress, EmailEditOptions... options);
   
   void editAlias(String aliasAddress, String toEmailAddress);

   void delete(String accountAddress);

}